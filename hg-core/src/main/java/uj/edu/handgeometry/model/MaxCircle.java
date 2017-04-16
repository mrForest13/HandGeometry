package uj.edu.handgeometry.model;

import org.opencv.core.Point;

/**
 * Created by zaloguj on 11.03.2017.
 */
public class MaxCircle {

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
}
