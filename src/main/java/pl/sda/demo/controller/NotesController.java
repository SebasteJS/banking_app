package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerLiabilitiesDto;
import pl.sda.demo.dto.NotesDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class NotesController {

//    private final pl.sda.demo.service.NotesService NotesService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/notes")
//    public String customerLiabilities(Model model) {
//        model.addAttribute("notess", NotesService.findAll());
//        model.addAttribute("notes", NotesDto.builder().build());
//        return "notes";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/notes")
//    public String customerLiabilitiesAdding(Model model, @ModelAttribute("notes") @Valid NotesDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            NotesService.add(user2);
//        }
//        model.addAttribute("notess", new NotesDto());
//
//        return "notes";
//    }
}
