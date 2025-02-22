package pase.gradiant.com.RetoGradiant.rest.dtos;

import pase.gradiant.com.RetoGradiant.model.entities.Technology;
import pase.gradiant.com.RetoGradiant.model.entities.User;

import java.util.List;

public class TechnologiesOfUserDTO {

    private User user;
    private List<Technology> technologies;

    public TechnologiesOfUserDTO(User user, List<Technology> technologies) {
        this.user = user;
        this.technologies = technologies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "TechnologiesOfUserDTO{" +
                "user=" + user +
                ", technologies=" + technologies +
                '}';
    }
}
