package uj.edu.handgeometry.check.data;

import uj.edu.handgeometry.check.CheckGeometry;
import uj.edu.handgeometry.classifier.HgNonLinearSvn;
import uj.edu.handgeometry.classifier.SVN;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.context.ApplicationContextHolder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateusz ligeza on 17.04.2017.
 */
public class DataBase implements CheckGeometry {

    @Override
    public double checkAll(int numberToCheck) {

        List<SvnVector> list = ApplicationContextHolder.getDbService().findAll();

        List<SvnVector> listToLoad = list.stream().filter(e -> e.getNumber()!=numberToCheck).collect(Collectors.toList());
        List<SvnVector> listToCheck = list.stream().filter(e -> e.getNumber()==numberToCheck).collect(Collectors.toList());

        SVN svn = new HgNonLinearSvn(listToLoad);
        svn.train();

        List<SvnVector> result = listToCheck.stream().filter(e -> e.getLabel()==svn.predict(e)).collect(Collectors.toList());

        return result.size()/listToCheck.size();
    }
}
