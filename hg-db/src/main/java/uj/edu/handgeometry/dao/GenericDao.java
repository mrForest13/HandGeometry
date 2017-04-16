package uj.edu.handgeometry.dao;

/**
 * Created by zaloguj on 02.04.2017.
 */
public interface GenericDao {

    public <T> void insert(T user);
}
