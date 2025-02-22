package pase.gradiant.com.RetoGradiant.model.entities;

import org.springframework.data.repository.CrudRepository;

public interface CategoryDAO extends CrudRepository<Category, Long> {
    public Category findByName(String name);
    public boolean existsByName(String name);
}
