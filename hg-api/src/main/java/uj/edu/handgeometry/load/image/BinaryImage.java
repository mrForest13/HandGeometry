package uj.edu.handgeometry.load.image;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.context.ApplicationContextHolder;
import uj.edu.handgeometry.context.Directory;
import uj.edu.handgeometry.entity.scheme.one.HandScheme1;
import uj.edu.handgeometry.entity.scheme.user.HgUser;
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


    public void load(String path) throws FingerException {
        HandImage handImage = Contour.getFromBinaryImage(path);
        Geometry hand = new Hand(handImage);
        hand.init();

        hand.draw(path.replaceAll("bin","testywynik"),path);

        String userName = getUserNumber(path);

        HgUser hgUser = ApplicationContextHolder.getDbService().findByName(Integer.parseInt(userName));

        HandScheme1 hs = new HandScheme1(hand);
        hs.setPhotoNumber(Integer.parseInt(getPhotoNumber(path)));

        if(hgUser==null) {
            hgUser = new HgUser(Integer.parseInt(userName));
            ApplicationContextHolder.getDbService().insert(hgUser);
        }

        hs.setUser(hgUser);
        ApplicationContextHolder.getDbService().insert(hs);
    }

    @Override
    public void loadAll() throws FingerException {

        String directoryPath = ApplicationContextHolder.getDirectory().dataDirectory;

        List<String> fileNames = FileReader.getAll(directoryPath);

        for(String name : fileNames) load(directoryPath + File.separator + name+".jpg");

    }
}
