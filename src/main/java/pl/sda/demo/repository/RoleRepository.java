package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Role;
import pl.sda.demo.role.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByType(RoleType roleType);

}
