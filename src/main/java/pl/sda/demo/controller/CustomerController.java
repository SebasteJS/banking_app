package pl.sda.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.demo.model.Customer;
import pl.sda.demo.service.CustomerService;


@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String customers(Model model) {
        addCustomers(model);
        model.addAttribute("customer", Customer.builder().build());
        return "customers";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.add(customer);
        addCustomers(model);
        return "customers";
    }

    private void addCustomers(Model model) {
        model.addAttribute("customers", customerService.list());
    }
}
