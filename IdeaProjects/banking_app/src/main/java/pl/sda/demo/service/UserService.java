package pl.sda.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.exceptions.UserAlredyExistsException;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.repository.UserRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final pl.sda.demo.repository.UserRepository UserRepository;
    private final pl.sda.demo.repository.RoleRepository RoleRepository;


    public Long add(UserDto userDto) {
        List<Role> roles = userDto.getRoles();
        if (roles == null) {
            Role role = new Role(RoleType.CLIENT);
            RoleRepository.save(role);
            roles = Collections.singletonList(role);
        }


        List<User> lista = UserRepository.findAll();
        for (User user : lista) {
            if (UserRepository.findUserByLogin(user.getLogin()) == user) {
                throw new UserAlredyExistsException("User with given login already exists");
            }
        }

        User user1 = User.builder()
                .first_name(userDto.getFirst_name())
                .last_name(userDto.getLast_name())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .roles(roles)
                .build();
        UserRepository.save(user1);
        return user1.getId();
    }

    public List<UserDto> findAll() {

        List<UserDto> userDtoUser = new ArrayList<>();
        Iterable<User> users = UserRepository.findAll();
        for (User users2 : users) {
            userDtoUser.add(
                    UserDto.builder()
                            .first_name(users2.getFirst_name())
                            .last_name(users2.getLast_name())
//                            .login(users2.getLogin())
//                            .password(users2.getPassword(
                            .roles(users2.getRoles())
                            .build());
        }
        return userDtoUser;
    }
}



