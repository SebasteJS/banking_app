package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
