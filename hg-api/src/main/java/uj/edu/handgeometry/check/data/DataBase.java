package uj.edu.handgeometry.check.data;

import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.context.ApplicationContextHolder;
import uj.edu.handgeometry.entity.scheme.Table;

import java.util.List;

/**
 * Created by mateusz ligeza on 17.04.2017.
 */
public class DataBase {

    public void test() {
        List<SvnVector> list = ApplicationContextHolder.getDbService().findAll(Table.HANDSCHEME1);
        System.out.println(list.size());

        double[] print = list.get(0).getVector();

        for(Double d : print) System.out.println(d);
    }
}
