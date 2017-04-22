package uj.edu.handgeometry.image.helper;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.functional.IncreaseIndex;
import uj.edu.handgeometry.functional.IndexChange;
import uj.edu.handgeometry.functional.ReduceIndex;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.MaxCircle;
import uj.edu.handgeometry.model.PointsBetweenFingers;

import java.util.*;
import java.util.function.IntFunction;

/**
 * Created by mateusz ligeza on 17.03.2017.
 */
public class HandHelper {

    public static Map<Point, Double> getDistance(List<Point> points, MaxCircle maxCircle) {

        Map<Point, Double> pointsDistance = new LinkedHashMap<Point, Double>();

        points.forEach(p -> pointsDistance.put(p, distance(p, maxCircle.getCenter())));

        return pointsDistance;
    }


    public static List<TwoPoints> getDistanceAndAngle(List<Point> points, MaxCircle maxCircle) {

        Point[] pointsArray = points.toArray(new Point[5]);
        List<TwoPoints> pointsDistance = new ArrayList<TwoPoints>();

        for (int i = 0; i < 4; i++)
            for (int j = i + 1; j < 5; j++) {

                Point p1 = pointsArray[i];
                Point p2 = pointsArray[j];

                pointsDistance.add(new TwoPoints(p1, p2, distance(p1, p2), angle(p1, maxCircle.getCenter(), p2)));
            }

        return pointsDistance;
    }

    public static Double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public static Double angle(Point a, Point b, Point c) {

        Point ab = new Point(b.x - a.x, b.y - a.y);
        Point cb = new Point(b.x - c.x, b.y - c.y);

        double dot = (ab.x * cb.x + ab.y * cb.y); // dot product
        double cross = (ab.x * cb.y - ab.y * cb.x); // cross product

        double alpha = Math.atan2(cross, dot);

        return Math.abs(Math.floor(alpha * 180. / Math.PI + 0.5));
    }

    public static List<Point> subList(List<Point> points, FingerTips fingerTips,Point start,Point end) {

        List<Point> subList = new ArrayList<Point>();

        int startIndex = points.indexOf(start);

        IndexChange function;

        do {

            Point p = points.get(startIndex++);

            Optional<Finger> finger = fingerTips.contain(p);

            if(finger.isPresent()) {
                if(finger.get().equals(Finger.LITTLE)) {
                    function = new ReduceIndex();
                    break;
                } else if(finger.get().equals(Finger.INDEX)) {
                    function = new IncreaseIndex();
                    break;
                }
            }

            if(startIndex==points.size()) startIndex = 0;

        } while(true);

        startIndex = points.indexOf(start);
        subList.add(start);
        Point p = null;

        do {

            startIndex  = function.apply(startIndex,points.size());
            p = points.get(startIndex);
            subList.add(p);

        } while(!p.equals(end));

        return subList;
    }

    public static Point lineCenter(Point p1, Point p2) {
        int x = (int)(p1.x+p2.x)/2;
        int y = (int)(p1.y+p2.y)/2;

        return new Point(x,y);
    }

    public static Point parallelPoint(Point A, Point C, List<Point> points,
                                      IndexChange indexChange, PointsBetweenFingers pBf) {

        Point p,r = null;
        double min = 360;

        int startIndex = points.indexOf(A);

        do {

            p = points.get(startIndex);
            startIndex = indexChange.apply(startIndex,points.size());

            if(Math.abs(90-angle(A,C,p))<min) {
                r=new Point(p.x,p.y);
                min = Math.abs(90-angle(A,C,p));
            }

        } while (!pBf.contains(p));

        return r;
    }

    public static List<Point> divideLine(Point start, Point end, int segments) {
        double x_delta = ((end.x - start.x) / segments);
        double y_delta = ((end.y - start.y) / segments);

        List<Point> points = new ArrayList<>();

        for(int i = 1; i<segments;i++)
            points.add(new Point(start.x+i*x_delta,start.y+i*y_delta));

        return points;
    }

}
