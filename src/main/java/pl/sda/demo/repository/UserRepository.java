package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
