package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

//    Role findByType(RoleType roleType);

}
