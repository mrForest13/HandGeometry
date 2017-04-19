package uj.edu.handgeometry.dao;


import uj.edu.handgeometry.entity.scheme.Table;

import java.util.List;

/**
 * Created by zaloguj on 02.04.2017.
 */
public interface GenericDao {

    public <T> void insert(T o);
    public <T> List<T> findAll(Table tablename);
}
