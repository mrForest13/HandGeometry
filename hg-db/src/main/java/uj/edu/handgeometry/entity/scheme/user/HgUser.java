package uj.edu.handgeometry.entity.scheme.user;

import uj.edu.handgeometry.classifier.vector.SvnVector;
import uj.edu.handgeometry.entity.scheme.one.HandScheme1;
import uj.edu.handgeometry.entity.scheme.two.HandScheme2;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mateusz ligeza on 08.04.2017.
 */
@Entity
public class HgUser {

    @Id
    @GeneratedValue
    private long id;

    private Integer userNumber;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",targetEntity = HandScheme2.class)
    private List<SvnVector> geometry;

    public HgUser() {}

    public HgUser(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer usernumber) {
        this.userNumber = usernumber;
    }

    public List<SvnVector> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<SvnVector> geometry) {
        this.geometry = geometry;
    }
}
