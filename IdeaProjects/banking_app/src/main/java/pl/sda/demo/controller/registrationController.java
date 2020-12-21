package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.service.UserService;
import pl.sda.demo.dto.UserDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService UserService;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("users",UserService.findAll());
        model.addAttribute("user", UserDto.builder().build());
        return "registration-form";
    }


    @PostMapping("/registration")
    public String registrationAdding(Model model, @ModelAttribute("user") @Valid UserDto user2, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            UserService.add(user2);
        }

        model.addAttribute("users", new UserDto());
        return "registration-form";
    }

}
