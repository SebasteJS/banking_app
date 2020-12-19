package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.ClientDto;
import pl.sda.demo.service.ClientService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ClientFormController {

//    @Secured({"ROLE_ADVISOR", "CLIENT"})
//    @GetMapping("/client")
//    public String login() {
//        return "client";
//    }


    private final pl.sda.demo.service.ClientService ClientService;

    @Secured({"ROLE_ADVISOR", "CLIENT"})
    @GetMapping("/client")
    public String client(Model model) {
        model.addAttribute("clients", ClientService.findAll());
        model.addAttribute("client", ClientDto.builder().build());
        return "client";
    }


    @Secured({"ROLE_ADVISOR", "CLIENT"})
    @PostMapping("/client")
    public String creditAdding(Model model, @ModelAttribute("client") @Valid ClientDto user2, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ClientService.add(user2);
        }
        model.addAttribute("credits", new ClientDto());

        return "client";
    }
}
