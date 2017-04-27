package uj.edu.handgeometry.image;

import org.opencv.core.Point;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.image.helper.HandHelper;
import uj.edu.handgeometry.image.helper.TwoPoints;
import uj.edu.handgeometry.initialization.FingersInitialization;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.HandImage;
import uj.edu.handgeometry.model.MaxCircle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class HandFingers implements FingersInitialization {

    @Override
    public FingerTips get(HandImage handImage, MaxCircle maxCircle) throws FingerException {

        List<Point> points = getFingerPoints(handImage, maxCircle,1.7);

        if (points.size() < 5) {
            points = getFingerPoints(handImage, maxCircle,1.5);

            if (points.size() < 5) throw new FingerException();
        }

        if(points.size()>5) points = getFive(points);

        return loadFingerTipsPoint(points, maxCircle);
    }

    private List<Point> getFingerPoints(HandImage handImage, MaxCircle maxCircle, double range) {

        ArrayList<Point> fingersPoint = new ArrayList<Point>();

        Map<Point, Double> map = HandHelper.getDistance(handImage.getContour(), maxCircle);

        Map<Point, Double> points = new HashMap<Point, Double>();

        boolean ifFirstInRange = false;
        int first = 0;

        for (Map.Entry<Point, Double> entry : map.entrySet()) {

            if (entry.getValue() > maxCircle.getRadius() * range) {

                if (first == 0) {
                    ifFirstInRange = true;
                    first++;
                }

                points.put(entry.getKey(), entry.getValue());

            } else if (!points.isEmpty()) {
                Point maxPoint = points.entrySet().stream().max((entry1, entry2) ->
                        entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
                fingersPoint.add(maxPoint);
                points.clear();

            } else if (first == 0) first++;
        }

        if (ifFirstInRange) {
            Point maxPoint = points.entrySet().stream().max((entry1, entry2) ->
                    entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            if (HandHelper.distance(fingersPoint.get(0), maxCircle.getCenter()) <
                    HandHelper.distance(maxPoint, maxCircle.getCenter()))
                fingersPoint.set(0, maxPoint);
        }

        return fingersPoint;
    }

    private FingerTips loadFingerTipsPoint(List<Point> points, MaxCircle maxCircle) {

        FingerTips fingerTips = new FingerTips();

        List<TwoPoints> fingerPoints = HandHelper.getDistanceAndAngle(points,maxCircle);

        fingerPoints.sort((TwoPoints p1, TwoPoints p2)->p1.getAngle()>p2.getAngle() ?
                1 : p1.getAngle()<p2.getAngle() ? -1 : 0);

        Point p1 = fingerPoints.get(fingerPoints.size()-1).getP1();
        Point p2 = fingerPoints.get(fingerPoints.size()-1).getP2();

        TwoPoints p3 = fingerPoints.stream().filter(p -> p.getP1().equals(p1)
                || p.getP2().equals(p1)).sorted((TwoPoints t1, TwoPoints t2)->t1.getDistance()>t2.getDistance() ?
                1 : t1.getDistance()<t2.getDistance() ? -1 : 0).collect(Collectors.toList()).get(0);

        TwoPoints p4 = fingerPoints.stream().filter(p -> p.getP1().equals(p2)
                || p.getP2().equals(p2)).sorted((TwoPoints t1, TwoPoints t2)->t1.getDistance()>t2.getDistance() ?
                1 : t1.getDistance()<t2.getDistance() ? -1 : 0).collect(Collectors.toList()).get(0);

        if(p3.getDistance()<p4.getDistance()) {
            fingerTips.setLittleFinger(p1);
            Point ring = !p3.getP1().equals(p1) ? p3.getP1() : p3.getP2();
            fingerTips.setRingFinger(ring);
            fingerTips.setThumb(p2);
            Point index = !p4.getP1().equals(p2) ? p4.getP1() : p4.getP2();
            fingerTips.setIndexFinger(index);
            Point middle = points.stream().filter(p -> !p.equals(p1) && !p.equals(p2) && !p.equals(ring)
                    && !p.equals(index)).findFirst().get();
            fingerTips.setMiddleFinger(middle);
        } else {
            fingerTips.setLittleFinger(p2);
            Point ring = !p4.getP1().equals(p2) ? p4.getP1() : p4.getP2();
            fingerTips.setRingFinger(ring);
            fingerTips.setThumb(p1);
            Point index = !p3.getP1().equals(p1) ? p3.getP1() : p3.getP2();
            fingerTips.setIndexFinger(index);
            Point middle = points.stream().filter(p -> !p.equals(p1) && !p.equals(p2) && !p.equals(ring)
                    && !p.equals(index)).findFirst().get();
            fingerTips.setMiddleFinger(middle);
        }

        return fingerTips;
    }

    private List<Point> getFive(List<Point> points) {

        Collections.sort(points, (o1, o2) -> o1.y > o2.y ? 1 : (o1.y < o2.y ? -1 : 0));

        return points.subList(0,5);
    }

}
