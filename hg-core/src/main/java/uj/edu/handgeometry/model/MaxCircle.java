package uj.edu.handgeometry.model;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import uj.edu.handgeometry.model.draw.DrawImage;
import uj.edu.handgeometry.model.draw.DrawProperties;

import static uj.edu.handgeometry.model.draw.DrawProperties.getBlue;

/**
 * Created by zaloguj on 11.03.2017.
 */
public class MaxCircle implements DrawImage {

    private Point center;
    private Double radius;

    public MaxCircle(Point center, Double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Mat mat) {
        Core.circle(mat, center, DrawProperties.getRadius(), getBlue());
        Core.circle(mat, center, new Double(radius).intValue(), getBlue());
    }
}
