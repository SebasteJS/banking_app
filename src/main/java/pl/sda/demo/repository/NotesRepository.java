package pl.sda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.demo.model.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

}
