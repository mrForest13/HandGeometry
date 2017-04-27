package uj.edu.handgeometry.model;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import uj.edu.handgeometry.image.helper.HandHelper;
import uj.edu.handgeometry.image.helper.TwoPoints;
import uj.edu.handgeometry.model.draw.DrawImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static uj.edu.handgeometry.model.draw.DrawProperties.*;

/**
 * Created by zaloguj on 25.03.2017.
 */
public class PointsBetweenFingers implements DrawImage {

    private Point littleRing;
    private Point ringMiddle;
    private Point indexMiddle;
    private Point thumbIndex;
    private Point thumbExternal;
    private Point littleExternal;
    private Point indexExternal;

    public Point getThumbExternal() {
        return thumbExternal;
    }

    public void setThumbExternal(Point thumbExternal) {
        this.thumbExternal = thumbExternal;
    }

    public List<Point> getCenters() {

        List<Point> result = new ArrayList<>();

        result.add(HandHelper.lineCenter(thumbExternal,thumbIndex));
        result.add(HandHelper.lineCenter(indexExternal,indexMiddle));
        result.add(HandHelper.lineCenter(ringMiddle,indexMiddle));
        result.add(HandHelper.lineCenter(ringMiddle,littleRing));
        result.add(HandHelper.lineCenter(littleRing,littleExternal));

        return result;
    }

    public boolean contains(Point p) {
        if(p.equals(littleRing)) return true;
        if(p.equals(ringMiddle)) return true;
        if(p.equals(indexMiddle)) return true;
        if(p.equals(thumbIndex)) return true;
        if(p.equals(thumbExternal)) return true;
        if(p.equals(littleExternal)) return true;
        if(p.equals(indexExternal)) return true;
        return false;
    }

    public List<Point> getPoints() {
        return Arrays.asList(littleRing,ringMiddle,indexMiddle,
                thumbIndex,thumbExternal,littleExternal,indexExternal);
    }

    private List<TwoPoints> getLine() {
        return Arrays.asList(new TwoPoints(thumbExternal,thumbIndex),
                new TwoPoints(indexExternal,indexMiddle),
                new TwoPoints(indexMiddle,ringMiddle),
                new TwoPoints(ringMiddle,littleRing),
                new TwoPoints(littleRing,littleExternal));
    }

    public Point getLittleExternal() {
        return littleExternal;
    }

    public void setLittleExternal(Point littleExternal) {
        this.littleExternal = littleExternal;
    }

    public Point getIndexExternal() {
        return indexExternal;
    }

    public void setIndexExternal(Point indexExternal) {
        this.indexExternal = indexExternal;
    }

    public Point getLittleRing() {
        return littleRing;
    }

    public void setLittleRing(Point littleRing) {
        this.littleRing = littleRing;
    }

    public Point getRingMiddle() {
        return ringMiddle;
    }

    public void setRingMiddle(Point ringMiddle) {
        this.ringMiddle = ringMiddle;
    }

    public Point getIndexMiddle() {
        return indexMiddle;
    }

    public void setIndexMiddle(Point indexMiddle) {
        this.indexMiddle = indexMiddle;
    }

    public Point getThumbIndex() {
        return thumbIndex;
    }

    public void setThumbIndex(Point thumbIndex) {
        this.thumbIndex = thumbIndex;
    }

    @Override
    public void draw(Mat mat) {
        getPoints().forEach(p ->  Core.circle(mat, p,getRadius(), getBlue()));
        getLine().forEach(l -> l.draw(mat));
    }
}
