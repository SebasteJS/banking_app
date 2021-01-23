package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CustomerIncomeController {
    private final pl.sda.demo.service.CustomerIncomeService customerIncomeService;
    private final pl.sda.demo.repository.CustomerIncomeRepository customerIncomeRepository;

    //    @Secured({"ROLE_ADVISOR"})
    @GetMapping("/customer")
    public String customerIncome(Model model) {
        if (!customerIncomeRepository.findAll().isEmpty() || customerIncomeRepository.findAll().size() != 0) {
            model.addAttribute("customersIncome", customerIncomeService.findAll());
            model.addAttribute("customerIncome", new CustomerIncomeDto());
        }
        model.addAttribute("customersIncome", customerIncomeService.findAll());
        model.addAttribute("customerIncome", CustomerIncomeDto.builder().build());
        return "customers";
    }


    //    @Secured({"ROLE_ADVISOR"})
    @PostMapping("/customersIncome/add")
    public String customerIncomeAdding(Model model, @ModelAttribute("customerIncome") @Valid CustomerIncomeDto user2, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerIncomeService.add(user2);
        }

        return "customers";
    }
}
