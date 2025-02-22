package pase.gradiant.com.RetoGradiant.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTechnology;
    private String name;
    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    public Technology() {
    }
    public Technology(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Long getIdTechnology() {
        return idTechnology;
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
}
