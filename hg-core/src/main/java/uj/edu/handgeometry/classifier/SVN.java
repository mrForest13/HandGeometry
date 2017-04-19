package uj.edu.handgeometry.classifier;


import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.ml.CvSVM;
import uj.edu.handgeometry.classifier.vector.SvnVector;

import java.util.List;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
public abstract class SVN {

    protected CvSVM cvSVM;
    protected Mat trainingDataMat;
    protected Mat labelsMat;

    public SVN(List<SvnVector> vectors) {
        cvSVM = new CvSVM();

        Mat labelsMat = new Mat(vectors.size(), 1, CvType.CV_32FC1);
        Mat trainingDataMat = new Mat(vectors.size(),
                vectors.get(0).getVector().length, CvType.CV_32FC1);

        for (int i = 0; i < vectors.size(); i++) {
            SvnVector v = vectors.get(i);
            trainingDataMat.put(i, 0, v.getVector());
            labelsMat.put(i, 0, v.getLabel());
        }
    }

    public abstract void train();

    public float predict(SvnVector vector) {

        double[] v = vector.getVector();

        Mat sampleMat = new Mat(1,v.length, CvType.CV_32FC1);
        sampleMat.put(0,0, v);

        return cvSVM.predict(sampleMat);
    }
}
