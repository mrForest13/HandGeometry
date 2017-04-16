package uj.edu.handgeometry.model;

import org.opencv.core.Point;
import uj.edu.handgeometry.image.helper.HandHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaloguj on 25.03.2017.
 */
public class PointsBetweenFingers {

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

    public List<Point> getPoints() {

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
}
