package uj.edu.handgeometry.model;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import uj.edu.handgeometry.model.draw.DrawImage;

import java.util.ArrayList;
import java.util.List;

import static uj.edu.handgeometry.model.draw.DrawProperties.getBlue;

/**
 * Created by zaloguj on 11.03.2017.
 */
public class HandImage implements DrawImage {

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

    @Override
    public void draw(Mat mat) {

        MatOfPoint matOfPoint = new MatOfPoint();
        matOfPoint.fromList(contour);

        List<MatOfPoint> countour = new ArrayList<MatOfPoint>();
        countour.add(matOfPoint);

        Imgproc.drawContours(mat, countour, 0, getBlue(), 1);
    }
}
