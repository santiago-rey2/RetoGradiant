package pase.gradiant.com.RetoGradiant.entities;

import jakarta.persistence.*;

@Entity
@Table(name="UserTechnology")
public class UserTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
