package pl.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancialAdvisorController {
    //    @Secured("ROLE_ADVISOR")
    @GetMapping({"/", "/advisor-panel"})  // będzie advisor-panel + ID usera
    public String mainPage(Model model) {
        return "advisor-panel";
    }
}
