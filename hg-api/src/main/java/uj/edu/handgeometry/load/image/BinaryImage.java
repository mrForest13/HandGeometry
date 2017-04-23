package uj.edu.handgeometry.load.image;

import uj.edu.handgeometry.Geometry;
import uj.edu.handgeometry.context.ApplicationContextHolder;
import uj.edu.handgeometry.entity.scheme.two.HandScheme2;
import uj.edu.handgeometry.entity.scheme.user.HgUser;
import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.file.FileReader;
import uj.edu.handgeometry.image.*;
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
        Geometry hand = new Hand(handImage,new HandCircle(),new HandFingers(),
                new ConvexityDefects(),new HandWidths());

        hand.draw(path.replaceAll("bin", "wynik"), path);

        String userName = getUserNumber(path);

        HgUser hgUser = ApplicationContextHolder.getDbService().findByName(Integer.parseInt(userName));

        HandScheme2 hs = new HandScheme2(hand);
        hs.setPhotoNumber(Integer.parseInt(getPhotoNumber(path)));

        if (hgUser == null) {
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

        for (String name : fileNames) load(directoryPath + File.separator + name + ".jpg");

    }
}
