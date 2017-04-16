package uj.edu.handgeometry.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uj.edu.handgeometry.dao.GenericDao;

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
}
