package uj.edu.handgeometry.load;

import uj.edu.handgeometry.exception.FingerException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mateusz ligeza on 08.04.2017.
 */
public abstract class LoadGeometry {

    public abstract void load(String path) throws FingerException;

    public abstract void loadAll(String path) throws FingerException;

    public String getUserNumber(String path) {
        Path p = Paths.get(path);
        String fileName = p.getFileName().toString();

        return fileName.substring(0,3);
    }
}
