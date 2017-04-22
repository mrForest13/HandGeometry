import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import uj.edu.handgeometry.file.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class LoadBin {

    public static void main(String args[]) throws IOException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        List<String> files = FileReader.getAll("C:\\Users\\zaloguj\\Desktop\\IITD Palmprint V1\\user");

        for(String s : files) {

            File file = new File("C:\\Users\\zaloguj\\Desktop\\IITD Palmprint V1\\Right Hand\\"+s+".jpg");

            Mat mRgba = Highgui.imread(file.toString());

            Imgproc.GaussianBlur(mRgba, mRgba, new Size(15, 11), 3);


            Mat dst = mRgba.clone();

            System.out.println("start");

            Core.inRange(mRgba, new Scalar(0, 0, 55), new Scalar(255, 255, 255), dst);


            Highgui.imwrite("C:\\Users\\zaloguj\\Desktop\\IITD Palmprint V1\\bin\\" + file.getName(), dst);

        }
    }
}
