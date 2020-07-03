package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository {
    Role findByRole(String role);
}
