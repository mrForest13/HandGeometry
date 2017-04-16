package uj.edu.handgeometry.image;

import org.opencv.core.Point;

import java.util.List;

/**
 * Created by zaloguj on 11.03.2017.
 */
public class HandImage {

    private List<Point> contour;
    private int rows;
    private int cols;

    public HandImage(List<Point> contour, int rows, int cols) {
        this.contour = contour;
        this.rows = rows;
        this.cols = cols;
    }

    public List<Point> getContour() {
        return contour;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
