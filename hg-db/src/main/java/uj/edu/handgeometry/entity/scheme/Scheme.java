package uj.edu.handgeometry.entity.scheme;

import uj.edu.handgeometry.entity.scheme.user.HgUser;

import javax.persistence.*;

/**
 * Created by mateusz ligeza on 25.04.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Scheme {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private HgUser user;

    private int photoNumber;

    public HgUser getUser() {
        return user;
    }

    public void setUser(HgUser user) {
        this.user = user;
    }

    public int getPhotoNumber() {
        return photoNumber;
    }

    public void setPhotoNumber(int photoNumber) {
        this.photoNumber = photoNumber;
    }

}
