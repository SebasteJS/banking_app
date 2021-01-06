package pl.sda.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientFormController {

    @Secured({"ROLE_ADVISOR", "CLIENT"})
    @GetMapping("/client")
    public String login() {
        return "client";
    }
}
