package pase.gradiant.com.RetoGradiant.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name="UserTechnology")
public class UserTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usertech_seq")
    @SequenceGenerator(name = "usertech_seq", sequenceName = "usertech_sequence", initialValue = 100, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idTechnology")
    private Technology technology;

    private String level;

    public UserTechnology() {}

    public UserTechnology(User user, Technology technology, String level) {
        this.user = user;
        this.technology = technology;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Technology getTechnology() {
        return technology;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserTechnology{" +
                "id=" + id +
                ", user=" + user +
                ", technology=" + technology +
                ", level='" + level + '\'' +
                '}';
    }
}
