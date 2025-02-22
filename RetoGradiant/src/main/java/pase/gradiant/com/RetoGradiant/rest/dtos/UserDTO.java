package pase.gradiant.com.RetoGradiant.rest.dtos;

import pase.gradiant.com.RetoGradiant.model.entities.User;

public class UserDTO {
    private Long id;
    private String pssw;
    private String name;
    private String email;
    private String role;

    public UserDTO() {
    }

    public UserDTO(Long id,String pssw ,String name, String email, String role) {
        this.id = id;
        this.pssw = pssw;
        this.name = name;
        this.email = email;
        this.role = role;
    }
    public UserDTO(User user){
        this.id = user.getIdUser();
        this.pssw = user.getPassword();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public String getPssw() {
        return pssw;
    }

    public void setPssw(String pssw) {
        this.pssw = pssw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
