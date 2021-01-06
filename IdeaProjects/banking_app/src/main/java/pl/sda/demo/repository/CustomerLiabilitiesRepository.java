package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.CustomerLiabilities;

@Repository
public interface CustomerLiabilitiesRepository extends JpaRepository<CustomerLiabilities, Long> {

//    Role findByType(RoleType roleType);

}
