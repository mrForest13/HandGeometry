package uj.edu.handgeometry.image;

import org.opencv.core.Point;
import uj.edu.handgeometry.functional.IncreaseIndex;
import uj.edu.handgeometry.functional.IndexChange;
import uj.edu.handgeometry.functional.ReduceIndex;
import uj.edu.handgeometry.image.helper.HandHelper;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.MaxCircle;
import uj.edu.handgeometry.model.PointsBetweenFingers;

import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

/**
 * Created by mateusz ligeza on 25.03.2017.
 */
public class HandConcavePoints {


    public static PointsBetweenFingers get(FingerTips fingerTips, HandImage handImage, MaxCircle maxCircle) {

        PointsBetweenFingers pointsBetweenFingers = new PointsBetweenFingers();

        List<Point> subList = HandHelper.subList(handImage.getContour(),
                fingerTips,fingerTips.getThumb(),fingerTips.getLittleFinger());


        pointsBetweenFingers.setThumbIndex(getLocalMin(subList, fingerTips.getThumb(),
                fingerTips.getIndexFinger(), maxCircle));
        pointsBetweenFingers.setIndexMiddle(getLocalMin(subList, fingerTips.getIndexFinger(),
                fingerTips.getMiddleFinger(), maxCircle));
        pointsBetweenFingers.setRingMiddle(getLocalMin(subList, fingerTips.getMiddleFinger(),
                fingerTips.getRingFinger(), maxCircle));
        pointsBetweenFingers.setLittleRing(getLocalMin(subList, fingerTips.getRingFinger(),
                fingerTips.getLittleFinger(), maxCircle));


        int index = subList.indexOf(fingerTips.getThumb());
        Point p1 = subList.get(index++);

        index = handImage.getContour().indexOf(fingerTips.getThumb());

        index = index > handImage.getContour().size() ? 0 : index;

        Point p2 = handImage.getContour().get(index++);

        if( !p1.equals(p2)) {

            pointsBetweenFingers.setThumbExternal(
                    getExternalPoint(pointsBetweenFingers.getThumbIndex(), fingerTips.getThumb(),
                            handImage.getContour(), new ReduceIndex()));

            pointsBetweenFingers.setLittleExternal(
                    getExternalPoint(pointsBetweenFingers.getLittleRing(), fingerTips.getLittleFinger(),
                            handImage.getContour(),new IncreaseIndex() ));

        } else {

            pointsBetweenFingers.setThumbExternal(
                    getExternalPoint(pointsBetweenFingers.getThumbIndex(), fingerTips.getThumb(),
                            handImage.getContour(), new IncreaseIndex()));

            pointsBetweenFingers.setLittleExternal(
                    getExternalPoint(pointsBetweenFingers.getLittleRing(), fingerTips.getLittleFinger(),
                            handImage.getContour(),new ReduceIndex() ));

        }

        pointsBetweenFingers.setIndexExternal(
                getExternalPoint(pointsBetweenFingers.getIndexMiddle(), fingerTips.getIndexFinger(),
                        subList, new ReduceIndex()));


        return pointsBetweenFingers;
    }

    private static Point getLocalMin(List<Point> points, Point start, Point end, MaxCircle maxCircle) {

        List<Point> subList = points.subList(points.indexOf(start), points.indexOf(end));

        Map<Point, Double> distanceMap = HandHelper.getDistance(subList, maxCircle);

        Double min = Double.MAX_VALUE;
        Point localMin = null;

        for (Map.Entry<Point, Double> entry : distanceMap.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                localMin = entry.getKey();
            }
        }

        return localMin;
    }


    private static Point getExternalPoint(Point start, Point middle, List<Point> points, IndexChange sup) {

        Double distance = HandHelper.distance(start, middle);
        Double d;
        Point p;

        int startIndex = points.indexOf(middle);

        do {

            p = points.get(startIndex);
            startIndex = sup.apply(startIndex,points.size());
            d = HandHelper.distance(p, middle);

        } while (d < distance);

        return p;
    }

}
