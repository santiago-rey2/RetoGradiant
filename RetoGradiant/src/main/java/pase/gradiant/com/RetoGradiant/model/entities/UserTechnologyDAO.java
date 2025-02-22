package pase.gradiant.com.RetoGradiant.model.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTechnologyDAO extends CrudRepository<UserTechnology, Long> {
    public List<UserTechnology> findByUser(User user);
    public boolean existsByUserAndTechnology(User user, Technology technology);
    public List<UserTechnology> findByTechnology_IdTechnology(Long idTechnology);
    public List<UserTechnology> findByUser_IdUser(Long idUser);

}
