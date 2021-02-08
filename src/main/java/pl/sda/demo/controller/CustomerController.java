package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.service.CustomerIncomeService;
import pl.sda.demo.service.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/customers") nie trzeba bo mamy w post i get wypisane adresy
//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADVISOR')")// robi to samo co @Secured mniej wiecej
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final CustomerIncomeService customerIncomeService;


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})// albo to albo @preauthorize na gorze
    @GetMapping("/customers")//bez tego kontrolra wyswietli customersow dobrze
    public String customers(Model model) {
        FinancialAdvisorController.checkingIfListIsNull(model, customerService);
        return "customers";
    }


    @Secured({"ROLE_ADMIN"})//
    @GetMapping("/customers-admin")// tu zmienilem z customers_admin na customers by wyswietlilo ustomersow
    public String customersAdmin(Model model) {
        if (!customerRepository.findAll().isEmpty() || customerRepository.findAll().size() != 0) {
            model.addAttribute("customers", customerService.listCustomers());
            model.addAttribute("customer", new CustomerDto());
        }
        if (customerRepository.findAll().isEmpty() || customerRepository.findAll().size() == 0) {
            model.addAttribute("customers", new ArrayList<CustomerDto>());
            model.addAttribute("customer", new CustomerDto());
        }
        return "customers";
    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @PostMapping("customers/add")
    public String addCustomer(@ModelAttribute("customer") @Valid CustomerDto customer, CustomerIncomeDto customerIncomeDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerIncomeService.add(customerIncomeDto);
            customerService.add(customer);
            return "advisor-panel";
        }
        return "customers";
    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @PostMapping("customers/update")
    public String updateCustomer(@ModelAttribute("customer") @Valid CustomerDto customer, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerService.update(customer);
            return "advisor-panel";
        }
        return "customers";
    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @PostMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute("customer") @Valid CustomerDto customer) {
        customerService.delete(customer.getId());
        return "customers";
    }
}
