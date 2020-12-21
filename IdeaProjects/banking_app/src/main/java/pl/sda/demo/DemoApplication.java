package pl.sda.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.sda.demo.Configuration.Configuration;
import pl.sda.demo.logic.CreditRateAndInterestsSimulator;
import pl.sda.demo.model.Credit;

@SpringBootApplication
@EntityScan("pl.sda.demo.model")
@EnableJpaRepositories("pl.sda.demo.repository")
@Import(Configuration.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        Credit credit1 = new Credit();
        credit1.setLoanAmmount(400000);
        credit1.setCreditPeriod(30);
        credit1.setInterestRate(3);
        CreditRateAndInterestsSimulator simulator = new CreditRateAndInterestsSimulator();

        simulator.setTerm(credit1);

        simulator.calculateCredit1(credit1);
        simulator.calculateCredit2(credit1);
        simulator.calculateCredit3(credit1);
    }
// comment
}
