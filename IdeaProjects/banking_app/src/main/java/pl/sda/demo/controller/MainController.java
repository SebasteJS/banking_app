package pl.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainController {

    @GetMapping({"/", "/index"})
    public String mainPage() {
        return "index";
    }
}
