package uj.edu.handgeometry.functional;

/**
 * Created by zaloguj on 15.04.2017.
 */
public class ReduceIndex implements IndexChange {
    @Override
    public int apply(int e, int size) {
        e--;
        if (e < 0) e = size - 1;
        return e;
    }
}
