package pase.gradiant.com.RetoGradiant.rest.dtos;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import pase.gradiant.com.RetoGradiant.model.entities.Technology;

public class DocumentDTO {
    private Long id;
    private String name;
    private String url;
    private String technology;

    public DocumentDTO() {
    }

    public DocumentDTO(String name, String url, String technology) {
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

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", technology=" + technology +
                '}';
    }
}
