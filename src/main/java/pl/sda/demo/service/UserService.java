package pl.sda.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.model.type.RoleType;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private Long currentID = 0L;

    public Long getCurrentID() {
        return currentID;
    }

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
                .build();
        currentID = user1.getId();
        userRepository.save(user1);
        return user1.getId();
    }

    public List<UserDto> findAll() {

        List<UserDto> userDtoUser = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User users2 : users) {
            userDtoUser.add(
                    UserDto.builder()
                            .firstName(users2.getFirstName())
                            .lastName(users2.getLastName())
//                            .login(users2.getLogin())
//                            .password(users2.getPassword())
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

            userRepository.save(user);
        }
    }


    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }


}



