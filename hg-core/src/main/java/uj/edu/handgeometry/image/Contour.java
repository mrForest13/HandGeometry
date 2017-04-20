package uj.edu.handgeometry.image;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mateusz ligeza on 09.04.2017.
 */
public class Contour {

    public static HandImage getFromBinaryImage(String filepath) {

        Mat bin = Highgui.imread(filepath);

        Imgproc.cvtColor(bin, bin, Imgproc.COLOR_RGB2GRAY);

        Imgproc.threshold(bin,bin,62,90,Imgproc.THRESH_BINARY);

        ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();

        Imgproc.findContours(bin, contours, new Mat(), Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_NONE);

        Collections.sort(contours, new Comparator<MatOfPoint>() {

            public int compare(MatOfPoint o1, MatOfPoint o2) {

                double a = Imgproc.contourArea(o1);
                double b = Imgproc.contourArea(o2);

                return a > b ? -1 : (a < b ? 1 : 0);
            }
        });

        List<Point> contour = contours.get(0).toList();

        return new HandImage(contour,bin.rows(),bin.cols());
    }

}
