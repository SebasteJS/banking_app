package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.repository.UserRepository;
import pl.sda.demo.model.type.RoleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DatabaseInitializationService implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder PasswordEncoder;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @Override
    public void run(String... args) {

        if (userRepository.findAll().size() != 0) {
            return;
        }

        Role userRole1 = new Role();
        userRole1.setType(RoleType.CLIENT);
        roleRepository.save(userRole1);
        Role userRole2 = new Role();
        userRole2.setType(RoleType.ADVISOR);
        roleRepository.save(userRole2);
        Role userRole3 = new Role();
        userRole3.setType(RoleType.ADMIN);
        roleRepository.save(userRole3);


        Role advisorRole = roleRepository.findByType(RoleType.ADVISOR);
        Role clientRole = roleRepository.findByType(RoleType.CLIENT);
        Role adminRole = roleRepository.findByType(RoleType.ADMIN);


        Customer cust = Customer.builder()
                .age(20)
                .email("krzyho.91@o2.pl")
                .kids(2)
                .lastName("mowak")
                .firstName("jan")
                .phone("999999999")
                .customerStatus("oczekujący")
                .build();
        customerRepository.save(cust);

        Customer cust2 = Customer.builder()
                .age(30)
                .email("krzyhoooooo.91@o2.pl")
                .kids(2)
                .lastName("Nowak")
                .firstName("jan")
                .phone("999999999")
                .customerStatus("oczekujący")
                .customerIncome(new CustomerIncome(3000.0, true, true, true, "",cust))
                .build();
        customerRepository.save(cust2);

        List<Customer> testCustomersList = new ArrayList<>();
        testCustomersList.add(cust);
        testCustomersList.add(cust2);


        userRepository.save(new User(null, "Marcin", "Kwiatkowski", "innyLogin",
                PasswordEncoder.encode("password"), Arrays.asList(advisorRole, clientRole, adminRole),
                testCustomersList));


//        userRepository.save(new User(null, "Tomek", "ASD", "loginJakis",
//                PasswordEncoder.encode("Innehaslo"), Arrays.asList(clientRole),
//                customerService.findCustomersForUser()));


    }
}
