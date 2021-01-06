package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.demo.model.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
