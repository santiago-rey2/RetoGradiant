package pase.gradiant.com.RetoGradiant.model.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "AppUsers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 100, allocationSize = 1)
    @Column(name = "ID_USER")
    private Long idUser;
    private String password;
    private String name;
    private String email;
    private String role;


    public User() {

    }

    public User(String password,String name, String email, String role) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
