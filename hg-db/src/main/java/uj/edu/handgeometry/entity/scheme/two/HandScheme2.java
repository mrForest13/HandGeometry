package uj.edu.handgeometry.entity.scheme.two;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.entity.scheme.user.HgUser;
import uj.edu.handgeometry.image.helper.HandHelper;

import javax.persistence.*;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
@Entity
public class HandScheme2 implements SvnVector {

    @Id
    @GeneratedValue
    private long id;

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


    private int photoNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private HgUser user;

    public HandScheme2() {}

    public HandScheme2(Geometry g) {
        thumbWidthTop = g.getThumbWidthTop();
        thumbWidthBot = g.getThumbWidthBot();
        indexWidthTop = g.getIndexWidthTop();
        indexWidthBot = g.getIndexWidthBot();
        middleWidthTop = g.getMiddleWidthTop();
        middleWidthBot = g.getMiddleWidthBot();
        ringWidthTop = g.getRingWidthTop();
        ringWidthBot = g.getRingWidthBot();
        littleWidthTop = g.getLittleWidthTop();
        littleWidthBot = g.getLittleWidthBot();
        palmWidth = g.getPalmWidth();
        thumbLenght = g.getThumbLenght();
        ringLenght = g.getRingLenght();
        indexLenght = g.getIndexLenght();
        middleLenght = g.getMiddleLenght();
        littleLenght = g.getLittleLenght();
    }


    private double mean(Geometry g) {
        return (g.getThumbWidthTop()+g.getThumbWidthBot()+g.getIndexWidthTop()+g.getIndexWidthBot()+
                g.getMiddleWidthTop()+g.getMiddleWidthBot()+g.getRingWidthTop()+g.getRingWidthBot()+
                g.getLittleWidthTop()+g.getLittleWidthBot()+g.getPalmWidth()+g.getThumbLenght()+
                g.getRingLenght()+g.getIndexLenght()+g.getMiddleLenght()+g.getLittleLenght())/16;
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

    public int getPhotoNumber() {
        return photoNumber;
    }

    public void setPhotoNumber(int photoNumber) {
        this.photoNumber = photoNumber;
    }

    public HgUser getUser() {
        return user;
    }

    public void setUser(HgUser user) {
        this.user = user;
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
                littleLenght
        };
    }

    @Override
    public int getLabel() {
        return user.getUserNumber();
    }

    @Override
    public int getNumber() {
        return photoNumber;
    }
}
