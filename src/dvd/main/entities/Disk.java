package dvd.main.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by anya on 07.09.2017.
 */

@Entity
@Table(name = "DISKS")
@Data
public class Disk {
    @Id
    @GeneratedValue
    @Column(name = "DISK_ID")
    private long id;

    @Column(name = "NAME")
    private String friendlyName;

    @JoinColumn(name = "OWNER")
    @ManyToOne
    private User owner;

    @JoinColumn(name = "HOLDER")
    @ManyToOne
    private User holder;

    @Override
    public String toString() {
        return "Disk{" +
                "id=" + id +
                ", friendlyName='" + friendlyName + '\'' +
                ", owner=" + (owner != null ? owner.getId() : null) +
                ", holder=" + (holder != null ? holder.getId() : null) +
                '}';
    }
}
