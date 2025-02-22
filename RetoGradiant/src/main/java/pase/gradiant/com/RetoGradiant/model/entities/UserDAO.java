package pase.gradiant.com.RetoGradiant.model.entities;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserDAO extends CrudRepository<User, Long> {
    public User findByEmail(String email);
    public boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.role = :role WHERE u.email = :email")
    public void updateRole(String email, String role);

}
