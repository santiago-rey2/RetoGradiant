package pase.gradiant.com.RetoGradiant.rest.dtos;

import pase.gradiant.com.RetoGradiant.model.entities.User;

public class UserTechnologyDTO {

    private User user;
    private String level;

    public UserTechnologyDTO() {
    }
    public UserTechnologyDTO(User user, String level) {
        this.user = user;
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserTechnologyDTO{" +
                "user=" + user +
                ", level='" + level + '\'' +
                '}';
    }
}
