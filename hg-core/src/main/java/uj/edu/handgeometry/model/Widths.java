package uj.edu.handgeometry.model;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import uj.edu.handgeometry.image.helper.TwoPoints;
import uj.edu.handgeometry.model.draw.DrawImage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
public class Widths implements DrawImage {

    private TwoPoints thumbWidthTop;
    private TwoPoints thumbWidthBot;
    private TwoPoints indexWidthTop;
    private TwoPoints indexWidthBot;
    private TwoPoints middleWidthTop;
    private TwoPoints middleWidthBot;
    private TwoPoints ringWidthTop;
    private TwoPoints ringWidthBot;
    private TwoPoints littleWidthTop;
    private TwoPoints littleWidthBot;

    public List<TwoPoints> getWidths() {
        return Arrays.asList(thumbWidthTop,thumbWidthBot,indexWidthTop,indexWidthBot,middleWidthTop,
                middleWidthBot,ringWidthTop,ringWidthBot,littleWidthTop,littleWidthBot);
    }

    public TwoPoints getThumbWidthTop() {
        return thumbWidthTop;
    }

    public void setThumbWidthTop(TwoPoints thumbWidthTop) {
        this.thumbWidthTop = thumbWidthTop;
    }

    public TwoPoints getThumbWidthBot() {
        return thumbWidthBot;
    }

    public void setThumbWidthBot(TwoPoints thumbWidthBot) {
        this.thumbWidthBot = thumbWidthBot;
    }

    public TwoPoints getIndexWidthTop() {
        return indexWidthTop;
    }

    public void setIndexWidthTop(TwoPoints indexWidthTop) {
        this.indexWidthTop = indexWidthTop;
    }

    public TwoPoints getIndexWidthBot() {
        return indexWidthBot;
    }

    public void setIndexWidthBot(TwoPoints indexWidthBot) {
        this.indexWidthBot = indexWidthBot;
    }

    public TwoPoints getMiddleWidthTop() {
        return middleWidthTop;
    }

    public void setMiddleWidthTop(TwoPoints middleWidthTop) {
        this.middleWidthTop = middleWidthTop;
    }

    public TwoPoints getMiddleWidthBot() {
        return middleWidthBot;
    }

    public void setMiddleWidthBot(TwoPoints middleWidthBot) {
        this.middleWidthBot = middleWidthBot;
    }

    public TwoPoints getRingWidthTop() {
        return ringWidthTop;
    }

    public void setRingWidthTop(TwoPoints ringWidthTop) {
        this.ringWidthTop = ringWidthTop;
    }

    public TwoPoints getRingWidthBot() {
        return ringWidthBot;
    }

    public void setRingWidthBot(TwoPoints ringWidthBot) {
        this.ringWidthBot = ringWidthBot;
    }

    public TwoPoints getLittleWidthTop() {
        return littleWidthTop;
    }

    public void setLittleWidthTop(TwoPoints littleWidthTop) {
        this.littleWidthTop = littleWidthTop;
    }

    public TwoPoints getLittleWidthBot() {
        return littleWidthBot;
    }

    public void setLittleWidthBot(TwoPoints littleWidthBot) {
        this.littleWidthBot = littleWidthBot;
    }

    @Override
    public void draw(Mat mat) {
        getWidths().forEach(w -> w.draw(mat));
    }
}
