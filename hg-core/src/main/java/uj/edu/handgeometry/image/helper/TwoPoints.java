package uj.edu.handgeometry.image.helper;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;

import static uj.edu.handgeometry.model.draw.DrawProperties.getBlue;
import static uj.edu.handgeometry.model.draw.DrawProperties.getRadius;

/**
 * Created by mateusz ligeza on 17.03.2017.
 */
public class TwoPoints implements Comparable<TwoPoints> {

    private Point p1;
    private Point p2;
    private Double distance;
    private Double angle;

    public TwoPoints(Point p1, Point p2, Double distance,Double angle) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
        this.angle = angle;
    }

    public TwoPoints(Point p1,Point p2, Double distance) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
    }

    public TwoPoints(Point p1, Point p2) {
        this.p1=p1;
        this.p2=p2;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(TwoPoints o) {
        return distance>o.distance ? 1 : distance<o.distance ? -1 : 0;
    }

    @Override
    public String toString() {
        return "TwoPoints{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", distance=" + distance +
                ", angle=" + angle +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return ((TwoPoints)obj).getP1().equals(this.p1) ||
                ((TwoPoints)obj).getP2().equals(this.p2) ? true : false;
    }

    public void draw(Mat mat) {

        Core.circle(mat, this.getP1(), getRadius(), getBlue());
        Core.circle(mat, this.getP2(), getRadius(), getBlue());

        Core.line(mat,p1,p2,getBlue());
    }
}
