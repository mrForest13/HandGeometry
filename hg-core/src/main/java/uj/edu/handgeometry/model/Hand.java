package uj.edu.handgeometry.model;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.classifier.properties.HgProperties;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.image.helper.TwoPoints;
import uj.edu.handgeometry.initialization.CircleInitialization;
import uj.edu.handgeometry.initialization.DefectsInitialization;
import uj.edu.handgeometry.initialization.FingersInitialization;
import uj.edu.handgeometry.initialization.WidthsInitialization;
import uj.edu.handgeometry.model.draw.DrawImage;

import java.io.File;
import java.util.Arrays;
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


    public Hand(HandImage handImage, CircleInitialization handCircle, FingersInitialization handFingers,
                DefectsInitialization convexityDefects, WidthsInitialization handWidths) throws FingerException {
        this.handImage = handImage;
        this.maxCircle = handCircle.get(handImage);
        this.fingerTips = handFingers.get(handImage, maxCircle);
        this.pBf = convexityDefects.get(fingerTips, handImage);
        this.widths = handWidths.get(fingerTips, pBf, handImage);
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

    private List<DrawImage> getModels() {
        return Arrays.asList(handImage, maxCircle, fingerTips,
                pBf, widths);
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
                + distance(pBf.getIndexMiddle(), pBf.getRingMiddle())
                + distance(pBf.getRingMiddle(), pBf.getLittleRing())
                + distance(pBf.getLittleRing(), pBf.getLittleExternal());
    }

    private List<TwoPoints> getFingersLines() {
        return Arrays.asList(new TwoPoints(fingerTips.getLittleFinger(),
                        lineCenter(pBf.getLittleRing(), pBf.getLittleExternal())),
                new TwoPoints(fingerTips.getThumb(),
                        lineCenter(pBf.getThumbExternal(), pBf.getThumbIndex())),
                new TwoPoints(fingerTips.getRingFinger(),
                        lineCenter(pBf.getLittleRing(), pBf.getRingMiddle())),
                new TwoPoints(fingerTips.getIndexFinger(),
                        lineCenter(pBf.getIndexExternal(), pBf.getIndexMiddle())),
                new TwoPoints(fingerTips.getMiddleFinger(),
                        lineCenter(pBf.getIndexMiddle(), pBf.getRingMiddle())));
    }

    @Override
    public void draw(String name) {

        if(!HgProperties.HG_DRAW) return;

        Mat mat = Highgui.imread(HgProperties.DATA_DIRECTORY + File.separator + name);

        getModels().forEach(m -> m.draw(mat));
        getFingersLines().forEach(fl -> fl.draw(mat));

        Highgui.imwrite(HgProperties.RESULT_DIRECTORY + File.separator + name, mat);
    }
}
