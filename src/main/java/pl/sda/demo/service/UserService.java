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


    public void updateCustomerList(Optional<User> user, List<Customer> inputList) {
        if (user.isPresent()) {
            User user1 = user.get();
            List<Customer> currentCustomers;
            if (!user1.getCustomers().isEmpty() && user1 != null) {
                currentCustomers = user1.getCustomers();
                currentCustomers.addAll(inputList);
                user1.setCustomers(currentCustomers);
            } else {
                user1.setCustomers(inputList);
            }
            userRepository.save(user1);
        }
    }

    public void updateCustomerList2(Optional<User> user, Customer customer) {
        if (user.isPresent()) {
            User user1 = user.get();
            List<Customer> currentCustomers = new ArrayList<>();
            if (!user1.getCustomers().isEmpty() && user1 != null) {
                currentCustomers = user1.getCustomers();
                currentCustomers.add(customer);
            } else {
                currentCustomers.add(customer);
            }
            user1.setCustomers(currentCustomers);
            userRepository.save(user1);
        }
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}



