package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.demo.exceptions.UserAlredyExistsException;
import pl.sda.demo.model.User;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findUserByLogin(String login);



}
