package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FailureController {

    @GetMapping("/failure")
    public String feature() {
        return "failure";
    }

}
