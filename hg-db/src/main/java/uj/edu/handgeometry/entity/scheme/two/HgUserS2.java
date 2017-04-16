package uj.edu.handgeometry.entity.scheme.two;

import uj.edu.handgeometry.entity.scheme.one.HandScheme1;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mateusz ligeza on 16.04.2017.
 */
@Entity
public class HgUserS2 {

    @Id
    @GeneratedValue
    private long id;

    private String usernumber;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<HandScheme2> geometry;

    public HgUserS2() {}

    public HgUserS2(String usernumber) {
        this.usernumber = usernumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public List<HandScheme2> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<HandScheme2> geometry) {
        this.geometry = geometry;
    }
}
