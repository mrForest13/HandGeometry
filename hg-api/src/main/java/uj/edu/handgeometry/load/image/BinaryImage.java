package uj.edu.handgeometry.load.image;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.context.ApplicationContextHolder;
import uj.edu.handgeometry.entity.scheme.one.HandScheme1;
import uj.edu.handgeometry.entity.scheme.one.HgUserS1;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.file.FileReader;
import uj.edu.handgeometry.image.Contour;
import uj.edu.handgeometry.image.HandImage;
import uj.edu.handgeometry.load.LoadGeometry;
import uj.edu.handgeometry.model.Hand;

import java.io.File;
import java.util.List;

/**
 * Created by mateusz ligeza on 09.04.2017.
 */
public class BinaryImage extends LoadGeometry {

    @Override
    public void load(String path) throws FingerException {
        HandImage handImage = Contour.getFromBinaryImage(path);
        Geometry hand = new Hand(handImage);
        hand.init();

        String userName = getUserNumber(path);

        HandScheme1 hs = new HandScheme1(hand);

        HgUserS1 hgUserS1 = new HgUserS1(Integer.parseInt(userName));

        hs.setUser(hgUserS1);

        ApplicationContextHolder.getDbService().insert(hgUserS1);
        ApplicationContextHolder.getDbService().insert(hs);
    }

    @Override
    public void loadAll(String directoryPath) throws FingerException {

        List<String> fileNames = FileReader.getAll(directoryPath);

        for(String name : fileNames) load(directoryPath + File.separator + name);

    }
}
