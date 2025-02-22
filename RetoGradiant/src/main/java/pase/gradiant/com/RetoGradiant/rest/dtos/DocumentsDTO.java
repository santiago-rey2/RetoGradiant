package pase.gradiant.com.RetoGradiant.rest.dtos;

import pase.gradiant.com.RetoGradiant.model.entities.Documents;
import pase.gradiant.com.RetoGradiant.model.entities.Technology;

import java.util.List;

public class DocumentsDTO {

    private Technology technology;
    private List<Documents> documents;

    public DocumentsDTO() {
    }
    public DocumentsDTO(Technology technology, List<Documents> documents) {
        this.technology = technology;
        this.documents = documents;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "DocumentsDAO{" +
                "technology=" + technology +
                ", documents=" + documents +
                '}';
    }
}
