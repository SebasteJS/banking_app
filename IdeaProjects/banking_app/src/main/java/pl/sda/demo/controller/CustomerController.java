package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.BrokerDto;
import pl.sda.demo.dto.CustomerDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CustomerController {

//    private final pl.sda.demo.service.CustomerService CustomerService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/customer")
//    public String customer(Model model) {
//        model.addAttribute("customers", CustomerService.findAll());
//        model.addAttribute("customer", CustomerDto.builder().build());
//        return "customer";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/customer")
//    public String customerAdding(Model model, @ModelAttribute("customer") @Valid CustomerDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            CustomerService.add(user2);
//        }
//        model.addAttribute("customers", new CustomerDto());
//
//        return "customer";
//    }
}
