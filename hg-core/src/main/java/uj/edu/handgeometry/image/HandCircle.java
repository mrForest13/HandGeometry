package uj.edu.handgeometry.image;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import uj.edu.handgeometry.initialization.CircleInitialization;
import uj.edu.handgeometry.model.MaxCircle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by mateusz ligeza on 11.03.2017.
 */
public class HandCircle implements CircleInitialization {

    @Override
    public MaxCircle get(HandImage handImage) {

        int row = handImage.getRows();
        int col = handImage.getCols();

        Mat transform = new Mat(row,col, CvType.CV_8UC1);

        MatOfPoint matOfPoint = new MatOfPoint();

        List<Point> list = handImage.getContour().stream().filter(p -> !(p.x==0 || p.x==col-1 || p.y==0 || p.y==row-1)).
                collect(Collectors.toList());;

        matOfPoint.fromList(list);

        ArrayList<MatOfPoint> point = new ArrayList<MatOfPoint>();
        point.add(matOfPoint);

        Imgproc.drawContours(transform, point, 0, new Scalar(255, 0, 0),
                Core.FILLED);

        Imgproc.distanceTransform(transform, transform, Imgproc.CV_DIST_L2,
                Imgproc.CV_DIST_MASK_PRECISE);

        return getMax(transform);
    }


    private MaxCircle getMax(Mat transform) {

        double max = 0;
        double x = 0, y = 0;

        for (int i = 0; i < transform.rows(); i++) {
            for (int j = 0; j < transform.cols(); j++) {
                if (transform.get(i, j)[0] > max) {
                    max = transform.get(i, j)[0];
                    x = j;
                    y = i;
                }
            }
        }

        return new MaxCircle(new Point(x,y),new Double(max));
    }
}
