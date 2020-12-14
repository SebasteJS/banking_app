package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.demo.dto.UserDto;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final pl.sda.demo.service.UserService UserService;


    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users",UserService.findAll());
        model.addAttribute("user", UserDto.builder().build());
        return "UserController";
    }
}
