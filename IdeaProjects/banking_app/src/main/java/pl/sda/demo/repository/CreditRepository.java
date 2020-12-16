package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

//    Role findByType(RoleType roleType);

}
