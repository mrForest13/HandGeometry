package uj.edu.handgeometry;

import org.opencv.core.Core;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.load.LoadGeometry;
import uj.edu.handgeometry.load.image.BinaryImage;

import java.io.IOException;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class LoadFromDirectory {

    public static void main(String args[]) throws IOException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        BinaryImage load = new BinaryImage();

        try {
            load.loadAll();
        } catch (FingerException e) {
            e.printStackTrace();
        }

    }
}
