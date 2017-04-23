package uj.edu.handgeometry.initialization;

import uj.edu.handgeometry.exception.FingerException;
import uj.edu.handgeometry.image.HandImage;
import uj.edu.handgeometry.model.FingerTips;
import uj.edu.handgeometry.model.MaxCircle;

/**
 * Created by mateusz ligeza on 22.04.2017.
 */
public interface FingersInitialization {

    public FingerTips get(HandImage handImage, MaxCircle maxCircle) throws FingerException;
}
