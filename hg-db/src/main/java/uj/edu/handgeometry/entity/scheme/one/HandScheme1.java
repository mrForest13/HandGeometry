package uj.edu.handgeometry.entity.scheme.one;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.entity.scheme.Scheme;

import javax.persistence.*;

/**
 * Created by mateusz ligeza on 02.04.2017.
 */
@Entity
public class HandScheme1 extends Scheme implements SvnVector {

    private double indexRing;
    private double indexLittle;
    private double indexMiddle;
    private double indexThumb;
    private double ringMiddle;
    private double ringLittle;
    private double ringThumb;
    private double middleLittle;
    private double middleThumb;
    private double littleThumb;
    private double indexRadius;
    private double thumbRadius;
    private double middleRadius;
    private double littleRadius;
    private double ringRadius;

    public HandScheme1(Geometry g) {
        indexRing = g.getIndexLenght() / g.getRingLenght();
        indexLittle = g.getIndexLenght() / g.getLittleLenght();
        indexMiddle = g.getIndexLenght() / g.getMiddleLenght();
        indexThumb = g.getIndexLenght() / g.getThumbLenght();
        indexRadius = g.getIndexLenght() / g.getRadius();
        ringMiddle = g.getRingLenght() / g.getMiddleLenght();
        ringLittle = g.getRingLenght() / g.getLittleLenght();
        ringThumb = g.getRingLenght() / g.getThumbLenght();
        ringRadius = g.getRingLenght() / g.getRadius();
        middleLittle = g.getMiddleLenght() / g.getLittleLenght();
        middleThumb = g.getMiddleLenght() / g.getThumbLenght();
        middleRadius = g.getMiddleLenght() / g.getRadius();
        littleThumb = g.getLittleLenght() / g.getThumbLenght();
        littleRadius = g.getLittleLenght() / g.getRadius();
        thumbRadius = g.getThumbLenght() / g.getRadius();
    }

    public HandScheme1() {
    }

    public double getIndexRing() {
        return indexRing;
    }

    public void setIndexRing(double indexRing) {
        this.indexRing = indexRing;
    }

    public double getIndexLittle() {
        return indexLittle;
    }

    public void setIndexLittle(double indexLittle) {
        this.indexLittle = indexLittle;
    }

    public double getIndexMiddle() {
        return indexMiddle;
    }

    public void setIndexMiddle(double indexMiddle) {
        this.indexMiddle = indexMiddle;
    }

    public double getIndexThumb() {
        return indexThumb;
    }

    public void setIndexThumb(double indexThumb) {
        this.indexThumb = indexThumb;
    }

    public double getRingMiddle() {
        return ringMiddle;
    }

    public void setRingMiddle(double ringMiddle) {
        this.ringMiddle = ringMiddle;
    }

    public double getRingLittle() {
        return ringLittle;
    }

    public void setRingLittle(double ringLittle) {
        this.ringLittle = ringLittle;
    }

    public double getRingThumb() {
        return ringThumb;
    }

    public void setRingThumb(double ringThumb) {
        this.ringThumb = ringThumb;
    }

    public double getMiddleLittle() {
        return middleLittle;
    }

    public void setMiddleLittle(double middleLittle) {
        this.middleLittle = middleLittle;
    }

    public double getMiddleThumb() {
        return middleThumb;
    }

    public void setMiddleThumb(double middleThumb) {
        this.middleThumb = middleThumb;
    }

    public double getLittleThumb() {
        return littleThumb;
    }

    public void setLittleThumb(double littleThumb) {
        this.littleThumb = littleThumb;
    }

    public double getIndexRadius() {
        return indexRadius;
    }

    public void setIndexRadius(double indexRadius) {
        this.indexRadius = indexRadius;
    }

    public double getThumbRadius() {
        return thumbRadius;
    }

    public void setThumbRadius(double thumbRadius) {
        this.thumbRadius = thumbRadius;
    }

    public double getMiddleRadius() {
        return middleRadius;
    }

    public void setMiddleRadius(double middleRadius) {
        this.middleRadius = middleRadius;
    }

    public double getLittleRadius() {
        return littleRadius;
    }

    public void setLittleRadius(double littleRadius) {
        this.littleRadius = littleRadius;
    }

    public double getRingRadius() {
        return ringRadius;
    }

    public void setRingRadius(double ringRadius) {
        this.ringRadius = ringRadius;
    }

    @Override
    public double[] getVector() {
        return new double[]{
                indexRing,
                indexLittle,
                indexMiddle,
                indexThumb,
                ringMiddle,
                ringLittle,
                ringThumb,
                middleLittle,
                middleThumb,
                littleThumb,
                indexRadius,
                thumbRadius,
                middleRadius,
                littleRadius,
                ringRadius,
        };
    }

    @Override
    public int getLabel() {
        return getUser().getUserNumber();
    }

    @Override
    public int getNumber() {
        return getPhotoNumber();
    }
}
