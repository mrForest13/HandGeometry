package uj.edu.handgeometry.model;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.image.*;

import java.util.ArrayList;
import java.util.List;

import static uj.edu.handgeometry.image.helper.HandHelper.distance;
import static uj.edu.handgeometry.image.helper.HandHelper.lineCenter;

/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class Hand implements Geometry {

    private HandImage handImage;
    private MaxCircle maxCircle;
    private FingerTips fingerTips;
    private PointsBetweenFingers pBf;
    private Widths widths;


    public Hand(HandImage handImage) {
        this.handImage = handImage;
    }

    public Widths getWidths() {
        return widths;
    }

    public HandImage getHandImage() {
        return handImage;
    }

    public MaxCircle getMaxCircle() {
        return maxCircle;
    }

    public FingerTips getFingerTips() {
        return fingerTips;
    }

    public PointsBetweenFingers getpBf() {
        return pBf;
    }

    public void init() throws FingerException {
        maxCircle = HandCircle.get(handImage);
        fingerTips = HandFingers.get(handImage, maxCircle);
        pBf = ConvexityDefects.get(fingerTips,handImage);
        //pBf = HandConcavePoints.get(fingerTips,handImage,maxCircle);
        widths = HandWidths.get(fingerTips, pBf, handImage);
    }

    @Override
    public Double getLittleLenght() {
        return distance(fingerTips.getLittleFinger(),
                lineCenter(pBf.getLittleRing(), pBf.getLittleExternal()));
    }

    @Override
    public Double getThumbLenght() {
        return distance(fingerTips.getThumb(),
                lineCenter(pBf.getThumbExternal(), pBf.getThumbIndex()));
    }

    @Override
    public Double getRingLenght() {
        return distance(fingerTips.getRingFinger(),
                lineCenter(pBf.getLittleRing(), pBf.getRingMiddle()));
    }

    @Override
    public Double getIndexLenght() {
        return distance(fingerTips.getIndexFinger(),
                lineCenter(pBf.getIndexExternal(), pBf.getIndexMiddle()));
    }

    @Override
    public Double getMiddleLenght() {
        return distance(fingerTips.getMiddleFinger(),
                lineCenter(pBf.getIndexMiddle(), pBf.getRingMiddle()));
    }

    @Override
    public Double getRadius() {
        return maxCircle.getRadius();
    }

    @Override
    public Double getThumbWidthTop() {
        return widths.getThumbWidthTop().getDistance();
    }

    @Override
    public Double getThumbWidthBot() {
        return widths.getThumbWidthBot().getDistance();
    }

    @Override
    public Double getIndexWidthTop() {
        return widths.getIndexWidthTop().getDistance();
    }

    @Override
    public Double getIndexWidthBot() {
        return widths.getIndexWidthBot().getDistance();
    }

    @Override
    public Double getMiddleWidthTop() {
        return widths.getMiddleWidthTop().getDistance();
    }

    @Override
    public Double getMiddleWidthBot() {
        return widths.getMiddleWidthBot().getDistance();
    }

    @Override
    public Double getRingWidthTop() {
        return widths.getRingWidthTop().getDistance();
    }

    @Override
    public Double getRingWidthBot() {
        return widths.getRingWidthBot().getDistance();
    }

    @Override
    public Double getLittleWidthTop() {
        return widths.getLittleWidthTop().getDistance();
    }

    @Override
    public Double getLittleWidthBot() {
        return widths.getLittleWidthBot().getDistance();
    }

    @Override
    public Double getPalmWidth() {
        return distance(pBf.getIndexExternal(), pBf.getIndexMiddle())
                +distance(pBf.getIndexMiddle(), pBf.getRingMiddle())
                +distance(pBf.getRingMiddle(), pBf.getLittleRing())
                +distance(pBf.getLittleRing(), pBf.getLittleExternal());
    }

    @Override
    public void draw(String filePath,String origin) {
        Mat mat = Highgui.imread(origin);

        MatOfPoint matOfPoint = new MatOfPoint();
        matOfPoint.fromList(handImage.getContour());

        List<MatOfPoint> countour = new ArrayList<MatOfPoint>();
        countour.add(matOfPoint);

        Scalar s = new Scalar(255, 0, 0);

        Imgproc.drawContours(mat, countour, 0, s, 1);

        Core.circle(mat, maxCircle.getCenter(), new Double(maxCircle.getRadius()).intValue(), s);
        Core.circle(mat,maxCircle.getCenter(),new Double(maxCircle.getRadius()*1.75).intValue(),s);

        Core.circle(mat, fingerTips.getThumb(), 15, s);
        Core.circle(mat, fingerTips.getIndexFinger(), 15, s);
        Core.circle(mat, fingerTips.getLittleFinger(), 15, s);
        Core.circle(mat, fingerTips.getRingFinger(), 15, s);
        Core.circle(mat, fingerTips.getMiddleFinger(), 15, s);

        Core.circle(mat, pBf.getLittleRing(), 15, s);
        Core.circle(mat, pBf.getRingMiddle(), 15, s);
        Core.circle(mat, pBf.getIndexMiddle(), 15, s);
        Core.circle(mat, pBf.getThumbIndex(), 15, s);
        Core.circle(mat, pBf.getLittleExternal(), 15, s);
        Core.circle(mat, pBf.getThumbExternal(), 15, s);
        Core.circle(mat, pBf.getIndexExternal(), 15, s);

        widths.getThumbWidthTop().draw(mat);
        widths.getThumbWidthBot().draw(mat);
        widths.getMiddleWidthBot().draw(mat);
        widths.getMiddleWidthTop().draw(mat);
        widths.getIndexWidthTop().draw(mat);
        widths.getIndexWidthBot().draw(mat);
        widths.getRingWidthTop().draw(mat);
        widths.getRingWidthBot().draw(mat);
        widths.getLittleWidthTop().draw(mat);
        widths.getLittleWidthBot().draw(mat);

        Highgui.imwrite(filePath, mat);


    }
}
