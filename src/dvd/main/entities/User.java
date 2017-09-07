package dvd.main.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anya on 07.09.2017.
 */

@Entity
@Table(name = "USERS")
@Data
public class User {
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long Id;

    @Column(name = "USER_LOGIN")
    private String login;

    @Column(name = "USER_PASS")
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Disk> myDisks = new ArrayList<Disk>();

    @OneToMany(mappedBy = "holder")
    private List<Disk> takenDisks = new ArrayList<Disk>();

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", login='" + login + '\'' +
                ", myDisks=" + myDisks +
                ", takenDisks=" + takenDisks +
                '}';
    }
}
