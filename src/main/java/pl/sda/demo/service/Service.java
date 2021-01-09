package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.repository.UserRepository;
import pl.sda.demo.role.RoleType;

import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class Service implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder PasswordEncoder;


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


        userRepository.save(new User(null, "Marcin", "Kwiatkowski", "innyLogin", PasswordEncoder.encode("password"), Arrays.asList(advisorRole)));
        userRepository.save(new User(null, "Tomek", "ASD", "loginJakis", PasswordEncoder.encode("Innehaslo"), Arrays.asList(clientRole)));
        userRepository.save(new User(null, "Kasia", "Nowak", "looogin", PasswordEncoder.encode("haslo3"), Arrays.asList(clientRole)));
        userRepository.save(new User(null, "SWA", "SWA", "SWA", PasswordEncoder.encode("SWA"), Arrays.asList(adminRole)));



    }

}
