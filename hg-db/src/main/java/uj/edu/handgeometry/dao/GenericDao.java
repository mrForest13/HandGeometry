package uj.edu.handgeometry.dao;


import uj.edu.handgeometry.entity.scheme.user.HgUser;

import java.util.List;

/**
 * Created by zaloguj on 02.04.2017.
 */
public interface GenericDao {

    public <T> void insert(T o);
    public <T> List<T> findAll();
    public HgUser findByName(int number);
}
