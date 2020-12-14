package pl.sda.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancialAdvisorController {

    @Secured("ROLE_ADVISOR")
    @GetMapping("/advisor")
        public String mainPage () {
            return "advisor_panel";
        }

    }


