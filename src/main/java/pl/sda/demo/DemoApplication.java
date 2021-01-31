package pl.sda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.sda.demo.config.SecurityConfig;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.logic.CreditRateAndInterestsSimulator;
import pl.sda.demo.model.Credit;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.User;
import pl.sda.demo.service.CustomerService;

@SpringBootApplication
@EntityScan("pl.sda.demo.model")
@EnableJpaRepositories("pl.sda.demo.repository")
@Import(SecurityConfig.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Credit credit1 = new Credit();
        credit1.setLoanAmmount(300000);
        credit1.setCreditPeriod(30);
        credit1.setInterestRate(3);
        CreditRateAndInterestsSimulator simulator = new CreditRateAndInterestsSimulator();

        simulator.calculateAll(credit1);
        simulator.showInfo();

//        CustomerDto customerTest = new CustomerDto();
//        customerTest.setAge(30);
//        customerTest.setCustomerStatus("jakiś");
//        customerTest.setEmail("jakiś@email.com");
//        customerTest.setKids(0);
//        customerTest.setFirstName("Ewa");
//        customerTest.setLastName("Nowaczek");
//        customerTest.setPhone("321654987");
//
//        CustomerService customerService = new CustomerService();
//        customerService.add(customerTest);

//        simulator.setTerm(credit1);
//
//        double monthlyRate1 = simulator.term1MonthlyRate1(credit1);
//        double monthlyRate2 = simulator.term1MonthlyRate2(credit1);
//        double monthlyRate3 = simulator.term1MonthlyRate3(credit1);
//
//        System.out.println(monthlyRate1);

//        simulator.calculateCredit1(credit1);
//        simulator.calculateCredit2(credit1);
//        simulator.calculateCredit3(credit1);
    }
// comment
}
