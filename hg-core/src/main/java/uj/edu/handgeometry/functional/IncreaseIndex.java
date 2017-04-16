package uj.edu.handgeometry.functional;

/**
 * Created by zaloguj on 15.04.2017.
 */
public class IncreaseIndex implements IndexChange {
    @Override
    public int apply(int e, int size) {
        e++;
        if (e > size - 1) e = 0;
        return e;
    }
}
