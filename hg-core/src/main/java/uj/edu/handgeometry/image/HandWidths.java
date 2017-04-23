package uj.edu.handgeometry.image;

import org.opencv.core.Point;
import uj.edu.handgeometry.functional.IncreaseIndex;
import uj.edu.handgeometry.functional.ReduceIndex;
import uj.edu.handgeometry.image.helper.HandHelper;
import uj.edu.handgeometry.image.helper.TwoPoints;
import uj.edu.handgeometry.initialization.WidthsInitialization;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.PointsBetweenFingers;
import uj.edu.handgeometry.model.Widths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
public class HandWidths implements WidthsInitialization {

    @Override
    public Widths get(FingerTips fingerTips, PointsBetweenFingers pBf, HandImage handImage) {

        Widths widths = new Widths();

        List<Point> subList = HandHelper.subList(handImage.getContour(),fingerTips,pBf.getThumbExternal(),
                pBf.getLittleExternal());

        List<Point> points = fingerPartPoints(fingerTips,pBf,subList);

        widths.setThumbWidthTop(widthPoint(fingerTips.getThumb(),points.get(0),subList,pBf));
        widths.setThumbWidthBot(widthPoint(fingerTips.getThumb(),points.get(1),subList,pBf));

        widths.setIndexWidthTop(widthPoint(fingerTips.getIndexFinger(),points.get(2),subList,pBf));
        widths.setIndexWidthBot(widthPoint(fingerTips.getIndexFinger(),points.get(3),subList,pBf));

        widths.setMiddleWidthTop(widthPoint(fingerTips.getMiddleFinger(),points.get(4),subList,pBf));
        widths.setMiddleWidthBot(widthPoint(fingerTips.getMiddleFinger(),points.get(5),subList,pBf));

        widths.setRingWidthTop(widthPoint(fingerTips.getRingFinger(),points.get(6),subList,pBf));
        widths.setRingWidthBot(widthPoint(fingerTips.getRingFinger(),points.get(7),subList,pBf));

        widths.setLittleWidthTop(widthPoint(fingerTips.getLittleFinger(),points.get(8),subList,pBf));
        widths.setLittleWidthBot(widthPoint(fingerTips.getLittleFinger(),points.get(9),subList,pBf));

        return widths;
    }

    private TwoPoints widthPoint(Point A, Point B, List<Point> sub,PointsBetweenFingers pBf) {
        Point p1 = HandHelper.parallelPoint(A, B, sub,new IncreaseIndex(),pBf);
        Point p2 = HandHelper.parallelPoint(A, B, sub,new ReduceIndex(),pBf);

        return new TwoPoints(p1,p2,HandHelper.distance(p1,p2));
    }

    private List<Point> fingerPartPoints(FingerTips fingerTips, PointsBetweenFingers
            pointsBetweenFingers, List<Point> sup) {

        List<Point> result = new ArrayList<>();
        List<Point> l = pointsBetweenFingers.getPoints();
        int i = 0;

        for(Point f : fingerTips.getFingers()) {
            List<Point> points = HandHelper.divideLine(f,l.get(i++),3);
            result.addAll(points);
        }

        return result;
    }
}
