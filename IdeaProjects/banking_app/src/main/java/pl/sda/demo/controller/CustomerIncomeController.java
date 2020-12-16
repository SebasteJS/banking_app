package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerIncomeDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CustomerIncomeController {
//    private final pl.sda.demo.service.CustomerIncomeService CustomerIncomeService;
//
//    @Secured({"ROLE_ADVISOR"})
//    @GetMapping("/customerIncome")
//    public String customerIncome(Model model) {
//        model.addAttribute("customersIncome", CustomerIncomeService.findAll());
//        model.addAttribute("customerIncome", CustomerIncomeDto.builder().build());
//        return "customerIncome";
//    }
//
//
//    @Secured({"ROLE_ADVISOR"})
//    @PostMapping("/customerIncome")
//    public String customerIncomeAdding(Model model, @ModelAttribute("customerIncome") @Valid CustomerIncomeDto user2, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            CustomerIncomeService.add(user2);
//        }
//        model.addAttribute("customersIncome", new CustomerIncomeDto());
//
//        return "customerIncome";
//    }
}
