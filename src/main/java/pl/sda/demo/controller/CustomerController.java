package pl.sda.demo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.service.CustomerService;
import javax.validation.Valid;
import java.util.ArrayList;
@Controller
//@RequestMapping("/customers") nie trzeba bo mamy w post i get wypisane adresy
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    @Secured({"ROLE_ADVISOR", "CLIENT"})//
    @GetMapping("/customers")
    public String customers(Model model) {
        if (!customerRepository.findAll().isEmpty() || customerRepository.findAll().size()!=0) {
            model.addAttribute("customers", customerService.listCustomers());
            model.addAttribute("customer", new CustomerDto());
        }
        model.addAttribute("customers", new ArrayList<CustomerDto>());
        model.addAttribute("customer", new CustomerDto());
        return "customers";
    }
    @Secured({"ROLE_ADVISOR", "CLIENT"})//
    @PostMapping("customers/add")
    public String addCustomer(@ModelAttribute("customer") @Valid CustomerDto customer, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerService.add(customer);
            return "advisor-panel";
        }
        return "advisor-panel";//
    }
    @Secured({"ROLE_ADVISOR", "CLIENT"})//
    @PostMapping("customers/update")
    public String updateCustomer(@ModelAttribute("customer") @Valid CustomerDto customer, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerService.update(customer);
            return "advisor-panel";
        }
        return "customers";
    }
    @Secured({"ROLE_ADVISOR", "CLIENT"})//
    @PostMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute("customer") @Valid CustomerDto customer) {
        customerService.delete(customer.getId());
        return "customers";
    }
}