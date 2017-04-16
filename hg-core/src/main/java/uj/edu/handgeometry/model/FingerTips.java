package uj.edu.handgeometry.model;

import org.opencv.core.Point;
import uj.edu.handgeometry.image.helper.Finger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class FingerTips {

    private Point thumb;
    private Point indexFinger;
    private Point middleFinger;
    private Point ringFinger;
    private Point littleFinger;

    public FingerTips() {}

    public FingerTips(Point thumb, Point indexFinger, Point middleFinger, Point ringFinger, Point littleFinger) {
        this.thumb = thumb;
        this.indexFinger = indexFinger;
        this.middleFinger = middleFinger;
        this.ringFinger = ringFinger;
        this.littleFinger = littleFinger;
    }

    public Optional<Finger> contain(Point p) {

        if(p.equals(thumb)) return Optional.of(Finger.THUMB);
        if(p.equals(indexFinger)) return Optional.of(Finger.INDEX);
        if(p.equals(middleFinger)) return Optional.of(Finger.MIDDLE);
        if(p.equals(ringFinger)) return Optional.of(Finger.RING);
        if(p.equals(littleFinger)) return Optional.of(Finger.LITTLE);
        return Optional.empty();

    }

    public List<Point> getFingers() {
        return Arrays.asList(thumb,indexFinger,middleFinger,ringFinger,littleFinger);
    }

    public Point getThumb() {
        return thumb;
    }

    public void setThumb(Point thumb) {
        this.thumb = thumb;
    }

    public Point getIndexFinger() {
        return indexFinger;
    }

    public void setIndexFinger(Point indexFinger) {
        this.indexFinger = indexFinger;
    }

    public Point getMiddleFinger() {
        return middleFinger;
    }

    public void setMiddleFinger(Point middleFinger) {
        this.middleFinger = middleFinger;
    }

    public Point getRingFinger() {
        return ringFinger;
    }

    public void setRingFinger(Point ringFinger) {
        this.ringFinger = ringFinger;
    }

    public Point getLittleFinger() {
        return littleFinger;
    }

    public void setLittleFinger(Point littleFinger) {
        this.littleFinger = littleFinger;
    }

}
