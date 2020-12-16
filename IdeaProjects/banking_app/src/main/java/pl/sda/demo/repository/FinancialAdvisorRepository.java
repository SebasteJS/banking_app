package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.FinanceAdvisor;

@Repository
public interface FinancialAdvisorRepository extends JpaRepository<FinanceAdvisor, Long> {

//    Role findByType(RoleType roleType);

}
