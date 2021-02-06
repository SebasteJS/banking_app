package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.service.CustomerService;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
    //    @Secured("ROLE_ADVISOR")
public class FinancialAdvisorController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping({"/", "/advisor-panel"})  // będzie advisor-panel + ID usera
    public String mainPage(Model model) {
        if (!customerService.findCustomersForUser().isEmpty() || customerService.findCustomersForUser().size() != 0) {
            model.addAttribute("customers", customerService.findCustomersForUser());
            model.addAttribute("customer", new Customer());
        }
        if (customerService.findCustomersForUser().isEmpty() || customerService.findCustomersForUser().size() == 0) {
            model.addAttribute("customers", new ArrayList<Customer>());
            model.addAttribute("customer", new Customer());
        }
        return "advisor-panel";
    }
}
