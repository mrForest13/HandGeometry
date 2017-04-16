package uj.edu.handgeometry.model;

import org.opencv.core.Point;
import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.image.*;
import uj.edu.handgeometry.image.helper.HandHelper;

/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class Hand implements Geometry {

    private HandImage handImage;
    private MaxCircle maxCircle;
    private FingerTips fingerTips;
    private PointsBetweenFingers pointsBetweenFingers;
    private Widths widths;


    public Hand(HandImage handImage) {
        this.handImage = handImage;
    }

    public Widths getWidths() { return widths; }

    public HandImage getHandImage() {
        return handImage;
    }

    public MaxCircle getMaxCircle() {
        return maxCircle;
    }

    public FingerTips getFingerTips() {
        return fingerTips;
    }

    public PointsBetweenFingers getPointsBetweenFingers() {
        return pointsBetweenFingers;
    }

    public void init() throws FingerException {
        maxCircle = HandCircle.get(handImage);
        fingerTips = HandFingers.get(handImage,maxCircle);
        pointsBetweenFingers = HandConcavePoints.get(fingerTips,handImage,maxCircle);
        widths = HandWidths.get(fingerTips,pointsBetweenFingers,handImage);
    }

    @Override
    public Double getLittleLenght() {
        return HandHelper.distance(fingerTips.getLittleFinger(),
                HandHelper.lineCenter(pointsBetweenFingers.getLittleRing(),pointsBetweenFingers.getLittleExternal()));
    }

    @Override
    public Double getThumbLenght() {
        return HandHelper.distance(fingerTips.getThumb(),
                HandHelper.lineCenter(pointsBetweenFingers.getThumbExternal(),pointsBetweenFingers.getThumbIndex()));
    }

    @Override
    public Double getRingLenght() {
        return HandHelper.distance(fingerTips.getRingFinger(),
                HandHelper.lineCenter(pointsBetweenFingers.getLittleRing(),pointsBetweenFingers.getRingMiddle()));
    }

    @Override
    public Double getIndexLenght() {
        return HandHelper.distance(fingerTips.getIndexFinger(),
                HandHelper.lineCenter(pointsBetweenFingers.getIndexExternal(),pointsBetweenFingers.getIndexMiddle()));
    }

    @Override
    public Double getMiddleLenght() {
        return HandHelper.distance(fingerTips.getMiddleFinger(),
                HandHelper.lineCenter(pointsBetweenFingers.getIndexMiddle(),pointsBetweenFingers.getRingMiddle()));
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
}
