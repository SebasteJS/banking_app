package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.NotesDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Notes;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NotesService {
    private final pl.sda.demo.repository.NotesRepository notesRepository;


    public Long add(NotesDto notesDto) {
        Notes notes1 = Notes.builder()
                .data(notesDto.getData())
                .note(notesDto.getNote())
                .build();
        notesRepository.save(notes1);
        return notesRepository.save(notes1).getId();
    }

    public List<NotesDto> findAll() {
        List<NotesDto> notesDtoUser = new ArrayList<>();
        Iterable<Notes> notess = notesRepository.findAll();
        for (Notes notess2 : notess) {
            notesDtoUser.add(
                    NotesDto.builder()
                            .data(notess2.getData())
                            .note(notess2.getNote())
                            .build());
        }
        return notesDtoUser;


    }
}
