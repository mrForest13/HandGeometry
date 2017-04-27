package uj.edu.handgeometry.model;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import uj.edu.handgeometry.image.helper.Finger;
import uj.edu.handgeometry.model.draw.DrawImage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static uj.edu.handgeometry.model.draw.DrawProperties.*;

/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class FingerTips implements DrawImage {

    private Point thumb;
    private Point indexFinger;
    private Point middleFinger;
    private Point ringFinger;
    private Point littleFinger;

    public FingerTips() {}

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

    @Override
    public void draw(Mat mat) {
        getFingers().forEach(p ->  Core.circle(mat, p, getRadius(), getBlue()));
    }
}
