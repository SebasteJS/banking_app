package pl.sda.demo.controller;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.service.CustomerService;
@Controller
public class FinancialAdvisorController {
    CustomerService customerService;
    //    @Secured("ROLE_ADVISOR")
    @GetMapping({"/","/advisor-panel"})
    public String mainPage (Model model) {
//        model.addAttribute("customers", customerService.listCustomers());
//        model.addAttribute("customer", new CustomerDto());
        return "advisor-panel";
    }
}
// @Secured({"ROLE_ADVISOR", "CLIENT"})//
//    @GetMapping
//    public String customers(Model model) {
//        model.addAttribute("customers", customerService.listCustomers());
//        model.addAttribute("customer", new CustomerDto());
//        return "customers";
//    }