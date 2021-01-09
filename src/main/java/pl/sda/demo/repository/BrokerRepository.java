package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long> {

}
