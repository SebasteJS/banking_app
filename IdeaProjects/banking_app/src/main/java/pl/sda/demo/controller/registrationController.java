package pl.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.demo.dto.ClientDto;

@Controller
public class registrationController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("client", new ClientDto());
        return "registration-form";
    }
}
