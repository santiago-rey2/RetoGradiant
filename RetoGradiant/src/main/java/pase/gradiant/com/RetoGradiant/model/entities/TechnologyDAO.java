package pase.gradiant.com.RetoGradiant.model.entities;

import org.springframework.data.repository.CrudRepository;

public interface TechnologyDAO extends CrudRepository<Technology, Long> {
    public Technology findByName(String name);
    public boolean existsByName(String name);

}