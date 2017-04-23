package uj.edu.handgeometry;

import org.opencv.core.Core;
import uj.edu.handgeometry.check.CheckGeometry;
import uj.edu.handgeometry.check.data.DataBase;

import java.io.File;
import java.io.IOException;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class Check {

    public static void main(String args[]) throws IOException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        CheckGeometry check = new DataBase();

        System.out.print(check.checkAll(5)*100+"%");
    }
}
