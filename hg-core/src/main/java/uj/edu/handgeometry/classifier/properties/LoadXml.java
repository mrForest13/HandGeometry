package uj.edu.handgeometry.classifier.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class LoadXml {

    public final static String XML_PATH = System.getenv("HG_ROOT");

    public static String get() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "svn.properties";
            input = LoadXml.class.getClassLoader().getResourceAsStream(filename);

            prop.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return XML_PATH+File.separator+"hg-classifier"+
                File.separator+prop.getProperty("svn.classifier.filename");
    }
}
