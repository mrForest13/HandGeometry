package uj.edu.handgeometry.classifier.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public class HgProperties {

    public final static String XML_PATH = System.getenv("HG_ROOT");
    private final static String HG_CONGIG = XML_PATH+File.separator+"hg-config";

    private final static String TEST_PROPERTIES = "test.properties";
    private final static String DATA = "test.directory.data";
    private final static String RESULT = "test.directory.result";

    private final static String CLASSIFIER = "svn.classifier.filename";
    private final static String SVN_PROPERTIES = "hg-config/svn.properties";

    public final static String DATA_DIRECTORY = getDataDirectory();
    public final static String HG_CLASSIFIER = getClassifier();
    public final static String RESULT_DIRECTORY = getResultDirectory();


    private static String getDataDirectory() {
        return load(HG_CONGIG+File.separator+TEST_PROPERTIES,DATA);
    }

    private static String getResultDirectory() {
        return load(HG_CONGIG+File.separator+TEST_PROPERTIES,RESULT);
    }

    private static String getClassifier() {
        return XML_PATH+File.separator+"hg-classifier"+
                File.separator+load(SVN_PROPERTIES,CLASSIFIER);
    }

    private static String load(String filename,String prop) {
        Properties properties = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(filename);

            properties.load(input);


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

        return properties.getProperty(prop);
    }
}