package uj.edu.handgeometry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.dao.GenericDao;
import uj.edu.handgeometry.entity.scheme.user.HgUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mateusz ligeza on 02.04.2017.
 */
@Component
public class DbService implements GenericDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    @Value("${geometry.schema.name}")
    private String tablename;

    @Transactional
    @Override
    public <T> void insert(T o) {
        em.persist(o);
    }

    @Transactional
    @Override
    public HgUser findByName(int number) {
        List<HgUser> result = em.createQuery("SELECT u FROM HgUser u where u.userNumber =" +
                number, HgUser.class).getResultList();

        if (result.isEmpty())
            return null;
        else
            return result.get(0);
    }

    @Transactional
    @Override
    public List<SvnVector> findAll() {
        return em.createQuery("SELECT v FROM " + this.tablename + " v", SvnVector.class).getResultList();
    }
}
