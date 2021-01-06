package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerIncome;

@Repository
public interface CustomerIncomeRepository extends JpaRepository<CustomerIncome, Long> {

//    Role findByType(RoleType roleType);

}
