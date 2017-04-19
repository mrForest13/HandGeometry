package uj.edu.handgeometry.entity.scheme;

/**
 * Created by mateusz ligeza on 17.04.2017.
 */
public enum Table {

    HANDSCHEME1("HandScheme1"),
    HANDSCHEME2("HandScheme2");

    private final String text;

    private Table(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
