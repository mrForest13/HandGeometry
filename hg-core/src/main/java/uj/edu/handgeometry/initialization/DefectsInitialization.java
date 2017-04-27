package uj.edu.handgeometry.initialization;

import uj.edu.handgeometry.model.HandImage;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.PointsBetweenFingers;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public interface DefectsInitialization {

    public PointsBetweenFingers get(FingerTips fingerTips, HandImage handImage);
}
