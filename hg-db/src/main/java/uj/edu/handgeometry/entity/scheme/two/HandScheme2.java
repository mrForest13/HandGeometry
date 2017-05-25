package uj.edu.handgeometry.entity.scheme.two;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.classifier.properties.HgProperties;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.entity.scheme.Scheme;

import javax.persistence.*;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
@Entity
public class HandScheme2 extends Scheme implements SvnVector {

    private Double thumbWidthTop;
    private Double thumbWidthBot;
    private Double indexWidthTop;
    private Double indexWidthBot;
    private Double middleWidthTop;
    private Double middleWidthBot;
    private Double ringWidthTop;
    private Double ringWidthBot;
    private Double littleWidthTop;
    private Double littleWidthBot;
    private Double palmWidth;
    private Double thumbLenght;
    private Double ringLenght;
    private Double indexLenght;
    private Double middleLenght;
    private Double littleLenght;

    @Transient
    private Double radius;

    public HandScheme2() {
    }

    public HandScheme2(Geometry g) {
        radius = g.getRadius();

        double r = resize();

        thumbWidthTop = g.getThumbWidthTop()*r;
        thumbWidthBot = g.getThumbWidthBot()*r;
        indexWidthTop = g.getIndexWidthTop()*r;
        indexWidthBot = g.getIndexWidthBot()*r;
        middleWidthTop = g.getMiddleWidthTop()*r;
        middleWidthBot = g.getMiddleWidthBot()*r;
        ringWidthTop = g.getRingWidthTop()*r;
        ringWidthBot = g.getRingWidthBot()*r;
        littleWidthTop = g.getLittleWidthTop()*r;
        littleWidthBot = g.getLittleWidthBot()*r;
        palmWidth = g.getPalmWidth()*r;
        thumbLenght = g.getThumbLenght()*r;
        ringLenght = g.getRingLenght()*r;
        indexLenght = g.getIndexLenght()*r;
        middleLenght = g.getMiddleLenght()*r;
        littleLenght = g.getLittleLenght()*r;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getThumbWidthTop() {
        return thumbWidthTop;
    }

    public void setThumbWidthTop(Double thumbWidthTop) {
        this.thumbWidthTop = thumbWidthTop;
    }

    public Double getThumbWidthBot() {
        return thumbWidthBot;
    }

    public void setThumbWidthBot(Double thumbWidthBot) {
        this.thumbWidthBot = thumbWidthBot;
    }

    public Double getIndexWidthTop() {
        return indexWidthTop;
    }

    public void setIndexWidthTop(Double indexWidthTop) {
        this.indexWidthTop = indexWidthTop;
    }

    public Double getIndexWidthBot() {
        return indexWidthBot;
    }

    public void setIndexWidthBot(Double indexWidthBot) {
        this.indexWidthBot = indexWidthBot;
    }

    public Double getMiddleWidthTop() {
        return middleWidthTop;
    }

    public void setMiddleWidthTop(Double middleWidthTop) {
        this.middleWidthTop = middleWidthTop;
    }

    public Double getMiddleWidthBot() {
        return middleWidthBot;
    }

    public void setMiddleWidthBot(Double middleWidthBot) {
        this.middleWidthBot = middleWidthBot;
    }

    public Double getRingWidthTop() {
        return ringWidthTop;
    }

    public void setRingWidthTop(Double ringWidthTop) {
        this.ringWidthTop = ringWidthTop;
    }

    public Double getRingWidthBot() {
        return ringWidthBot;
    }

    public void setRingWidthBot(Double ringWidthBot) {
        this.ringWidthBot = ringWidthBot;
    }

    public Double getLittleWidthTop() {
        return littleWidthTop;
    }

    public void setLittleWidthTop(Double littleWidthTop) {
        this.littleWidthTop = littleWidthTop;
    }

    public Double getLittleWidthBot() {
        return littleWidthBot;
    }

    public void setLittleWidthBot(Double littleWidthBot) {
        this.littleWidthBot = littleWidthBot;
    }

    public Double getPalmWidth() {
        return palmWidth;
    }

    public void setPalmWidth(Double palmWidth) {
        this.palmWidth = palmWidth;
    }

    public Double getThumbLenght() {
        return thumbLenght;
    }

    public void setThumbLenght(Double thumbLenght) {
        this.thumbLenght = thumbLenght;
    }

    public Double getRingLenght() {
        return ringLenght;
    }

    public void setRingLenght(Double ringLenght) {
        this.ringLenght = ringLenght;
    }

    public Double getIndexLenght() {
        return indexLenght;
    }

    public void setIndexLenght(Double indexLenght) {
        this.indexLenght = indexLenght;
    }

    public Double getMiddleLenght() {
        return middleLenght;
    }

    public void setMiddleLenght(Double middleLenght) {
        this.middleLenght = middleLenght;
    }

    public Double getLittleLenght() {
        return littleLenght;
    }

    public void setLittleLenght(Double littleLenght) {
        this.littleLenght = littleLenght;
    }

    @Override
    public double[] getVector() {
        return new double[]{
                thumbWidthTop,
                thumbWidthBot,
                indexWidthTop,
                indexWidthBot,
                middleWidthTop,
                middleWidthBot,
                ringWidthTop,
                ringWidthBot,
                littleWidthTop,
                littleWidthBot,
                palmWidth,
                thumbLenght,
                ringLenght,
                indexLenght,
                middleLenght,
                littleLenght,
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

    @Override
    public double resize() {
        return new Boolean(resize) ? 100/radius : 1;
    }
}
