package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CreditDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CreditController {

//    private final pl.sda.demo.service.CreditService CreditService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/credit")
//    public String credit(Model model) {
//        model.addAttribute("credits", CreditService.findAll());
//        model.addAttribute("credit", CreditDto.builder().build());
//        return "credit";
//    }
//
//
//    @Secured({"ROLE_ADVISOR", "CLIENT"})
//    @PostMapping("/credit")
//    public String creditAdding(Model model, @ModelAttribute("credit") @Valid CreditDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            CreditService.add(user2);
//        }
//        model.addAttribute("credits", new CreditDto());
//
//        return "credit";
//    }
}
