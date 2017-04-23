package uj.edu.handgeometry.initialization;

import uj.edu.handgeometry.image.HandImage;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.PointsBetweenFingers;
import uj.edu.handgeometry.model.Widths;

/**
 * Created by mateusz ligeza on 23.04.2017.
 */
public interface WidthsInitialization {

    public Widths get(FingerTips fingerTips, PointsBetweenFingers pBf, HandImage handImage);
}
