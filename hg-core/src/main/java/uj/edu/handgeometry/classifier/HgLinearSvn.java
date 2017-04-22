package uj.edu.handgeometry.classifier;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;
import org.opencv.ml.CvSVM;
import org.opencv.ml.CvSVMParams;
import uj.edu.handgeometry.classifier.vector.SvnVector;

import java.util.List;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
public class HgLinearSvn extends SVN {

    public HgLinearSvn(List<SvnVector> vectors) {
        super(vectors);
    }

    @Override
    public void train() {
        CvSVMParams params = new CvSVMParams();

        params.set_svm_type(CvSVM.C_SVC);
        params.set_kernel_type(CvSVM.LINEAR);
        params.set_term_crit(new TermCriteria(TermCriteria.MAX_ITER, 100, 1e-6));

        long startTime = System.currentTimeMillis();

        cvSVM.train(trainingDataMat,labelsMat,new Mat(),new Mat(),params);

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        logger.info("Learning time of the classifier: " + totalTime);
    }
}
