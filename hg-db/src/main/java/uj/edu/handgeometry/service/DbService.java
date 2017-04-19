package uj.edu.handgeometry.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import antlr.collections.impl.Vector;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.dao.GenericDao;
import uj.edu.handgeometry.entity.scheme.Table;

import java.util.List;

/**
 * Created by mateusz ligeza on 02.04.2017.
 */
@Component
public class DbService implements GenericDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public <T> void insert(T o) {
        em.persist(o);
    }

    @Transactional
    @Override
    public List<SvnVector> findAll(Table tablename) {
        return em.createQuery("SELECT v FROM "+tablename.toString()+" v", SvnVector.class).getResultList();
    }
}
