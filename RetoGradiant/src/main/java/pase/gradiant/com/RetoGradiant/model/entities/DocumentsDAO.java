package pase.gradiant.com.RetoGradiant.model.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentsDAO extends CrudRepository<Documents, Long> {
    public Documents findByName(String name);
    public boolean existsByUrl(String url);
    public List<Documents> findByTechnology_IdTechnology(Long id);
}
