package uj.edu.handgeometry;

import org.apache.log4j.Logger;
import org.opencv.core.Core;
import uj.edu.handgeometry.check.CheckGeometry;
import uj.edu.handgeometry.check.data.DataBase;

import java.io.File;
import java.io.IOException;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class CheckDataBase {

    private static final Logger logger = Logger.getLogger(CheckDataBase.class);

    public static void main(String args[]) throws IOException {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        CheckGeometry check = new DataBase();

        double result = 0;

        for(int i = 1; i<6; i++) {
            logger.info("Result for "+i+": = "+check.checkAll(i)*100);
            result+=check.checkAll(i)*100;
        }

        logger.info("Result: " + result/5 +"%");

    }
}
