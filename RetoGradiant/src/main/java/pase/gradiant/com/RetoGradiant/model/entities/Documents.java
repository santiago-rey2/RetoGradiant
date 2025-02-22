package pase.gradiant.com.RetoGradiant.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq")
    @SequenceGenerator(name = "doc_seq", sequenceName = "doc_sequence", initialValue = 100, allocationSize = 1)
    private Long id;
    private String name;
    @Column(length = 2048)
    private String url;
    @ManyToOne
    @JoinColumn(name = "idTechnology")
    private Technology technology;

    public Documents() {
    }
    public Documents(String name, String url, Technology technology) {
        this.name = name;
        this.url = url;
        this.technology = technology;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", technology=" + technology +
                '}';
    }
}
