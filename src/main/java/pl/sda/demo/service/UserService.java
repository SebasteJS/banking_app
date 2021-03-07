package pl.sda.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.model.type.RoleType;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.repository.UserRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private CustomerService customerService;

    Long userId = 6l;

    public Long add(UserDto userDto) {
        List<Role> roles = userDto.getRoles();
        if (roles == null) {
            Role role = new Role(RoleType.CLIENT);
            roleRepository.save(role);
            roles = Collections.singletonList(role);
        }

        User user1 = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roles(roles)
                .customers(userDto.getCustomers())//////////pomysl czy tak ma  byc
                .build();
        userRepository.save(user1);
        userId = user1.getId();
        return userId;
    }

    public List<UserDto> findAll() {

        List<UserDto> userDtoUser = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User users2 : users) {
            userDtoUser.add(
                    UserDto.builder()
                            .firstName(users2.getFirstName())
                            .lastName(users2.getLastName())
                            .roles(users2.getRoles())
                            .build());
        }
        return userDtoUser;
    }


    public void update(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setRoles(userDto.getRoles());
            user.setLogin(userDto.getLogin());
            user.setPassword(userDto.getPassword());
            user.setCustomers(userDto.getCustomers());////////pomysl czy tak ma byc
            userRepository.save(user);
        }
    }


    public void updateCustomerList(Optional user) {
        if (user.isPresent()) {
            User user1 = (User) user.get();
            List<Customer> currentCustomers = user1.getCustomers();
            Optional<User> optionalUser = userRepository.findById(userId);
            User user2 =(User) optionalUser.get();
            if (!user2.getCustomers().isEmpty() && user2.getCustomers() != null) {
                List<Customer> oldCustomers = user2.getCustomers();
                oldCustomers.addAll(currentCustomers);
                user2.setCustomers(oldCustomers);
                user1.setCustomers(user2.getCustomers()); ////////pomysl czy tak ma byc
                userRepository.save(user1);
            } else {
                List<Customer> newList = new ArrayList<>();
                user2.setCustomers(newList);
            }
        }
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}



