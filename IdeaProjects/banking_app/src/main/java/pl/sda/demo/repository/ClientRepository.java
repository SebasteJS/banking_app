package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

//    Role findByType(RoleType roleType);

}
