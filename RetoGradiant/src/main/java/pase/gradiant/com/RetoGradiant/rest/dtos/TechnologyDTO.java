package pase.gradiant.com.RetoGradiant.rest.dtos;

import pase.gradiant.com.RetoGradiant.model.entities.Category;
import pase.gradiant.com.RetoGradiant.model.entities.Technology;

public class TechnologyDTO {
    private Long id;
    private String name;
    private Category category;

    public TechnologyDTO() {
    }
    public TechnologyDTO(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    public TechnologyDTO(String name, Category category) {
        this.name = name;
        this.category = category;
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
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public static Technology toTechnology(TechnologyDTO technology) {
        return new Technology(technology.getName(),technology.getCategory());
    }
}
