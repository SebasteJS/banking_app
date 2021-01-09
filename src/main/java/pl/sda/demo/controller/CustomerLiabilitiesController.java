package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerLiabilitiesDto;
import pl.sda.demo.service.CustomerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CustomerLiabilitiesController {

//    private final pl.sda.demo.service.CustomerLiabilitiesService CustomerLiabilitiesService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/customerLiabilities")
//    public String customerLiabilities(Model model) {
//        model.addAttribute("customersLiabilities", CustomerLiabilitiesService.findAll());
//        model.addAttribute("customerLiabilities", CustomerLiabilitiesDto.builder().build());
//        return "customerLiabilities";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/customerLiabilities")
//    public String customerLiabilitiesAdding(Model model, @ModelAttribute("customerLiabilities") @Valid CustomerLiabilitiesDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            CustomerLiabilitiesService.add(user2);
//        }
//        model.addAttribute("customersLiabilities", new CustomerLiabilitiesDto());
//
//        return "customerLiabilities";
//    }
}
