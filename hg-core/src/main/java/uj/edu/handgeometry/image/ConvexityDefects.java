package uj.edu.handgeometry.image;

import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import uj.edu.handgeometry.functional.IncreaseIndex;
import uj.edu.handgeometry.functional.IndexChange;
import uj.edu.handgeometry.functional.ReduceIndex;
import uj.edu.handgeometry.image.helper.HandHelper;
import uj.edu.handgeometry.initialization.DefectsInitialization;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.HandImage;
import uj.edu.handgeometry.model.PointsBetweenFingers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz ligeza on 21.04.2017.
 */
public class ConvexityDefects implements DefectsInitialization{

    @Override
    public PointsBetweenFingers get(FingerTips fingerTips, HandImage handImage) {

        PointsBetweenFingers pointsBetweenFingers = new PointsBetweenFingers();

        MatOfPoint matOfPoint = new MatOfPoint();

        List<Point> subList = HandHelper.subList(handImage.getContour(),
                fingerTips,fingerTips.getThumb(),fingerTips.getLittleFinger());

        matOfPoint.fromList(subList);

        ArrayList<MatOfPoint> point = new ArrayList<MatOfPoint>();
        point.add(matOfPoint);

        MatOfInt4 convexityDefects = new MatOfInt4();

        int[] arr = new int[5];
        int i = 0;

        for(Point p : fingerTips.getFingers()) {
            int index = subList.indexOf(p);
            arr[i++]=index;
        }

        MatOfInt matOfInt = new MatOfInt(arr);

        Imgproc.convexityDefects(matOfPoint,matOfInt,convexityDefects);

        List<Integer> defects = convexityDefects.toList();

        pointsBetweenFingers.setThumbIndex(subList.get(defects.get(2)));
        pointsBetweenFingers.setIndexMiddle(subList.get(defects.get(6)));
        pointsBetweenFingers.setRingMiddle(subList.get(defects.get(10)));
        pointsBetweenFingers.setLittleRing(subList.get(defects.get(14)));

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

    private Point getExternalPoint(Point start, Point middle, List<Point> points, IndexChange sup) {

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
