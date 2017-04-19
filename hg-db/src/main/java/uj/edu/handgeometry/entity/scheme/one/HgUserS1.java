package uj.edu.handgeometry.entity.scheme.one;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zaloguj on 08.04.2017.
 */
@Entity
public class HgUserS1 {

    @Id
    @GeneratedValue
    private long id;

    private Integer usernumber;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<HandScheme1> geometry;

    public HgUserS1() {}

    public HgUserS1(Integer usernumber) {
        this.usernumber = usernumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(Integer usernumber) {
        this.usernumber = usernumber;
    }

    public List<HandScheme1> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<HandScheme1> geometry) {
        this.geometry = geometry;
    }
}
