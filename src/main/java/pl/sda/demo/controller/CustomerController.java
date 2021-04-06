package pl.sda.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.dto.PropertyDto;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.service.CustomerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/customers") nie trzeba bo mamy w post i get wypisane adresy
//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADVISOR')")// robi to samo co @Secured mniej wiecej
public class CustomerController {

    private final CustomerService customerService;

    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})// albo to albo @preauthorize na gorze
    @GetMapping("/customers")//bez tego kontrolra wyswietli customersow dobrze
    public String customers(Model model) {
        FinancialAdvisorController.checkingIfListIsNull(model, customerService);
        return "customers";
    }

    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})// albo to albo @preauthorize na gorze
    @ResponseBody
    @GetMapping("/customers/update")//bez tego kontrolra wyswietli customersow dobrze
    public String customers(Model model, String email) {
        FinancialAdvisorController.checkingIfListIsNull(model, customerService);
        return "customers" + email;
    }


//    @Secured({"ROLE_ADMIN"})//
//    @GetMapping("/customers-admin")// tu zmienilem z customers_admin na customers by wyswietlilo ustomersow
//    public String customersAdmin(Model model) {
//        if (!customerRepository.findAll().isEmpty() || customerRepository.findAll().size() != 0) {
//            model.addAttribute("customers", customerService.listCustomers());
//            model.addAttribute("customer", new CustomerDto());
//        }
//        if (customerRepository.findAll().isEmpty() || customerRepository.findAll().size() == 0) {
//            model.addAttribute("customers", new ArrayList<CustomerDto>());
//            model.addAttribute("customer", new CustomerDto());
//        }
//        return "customers";
//    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @PostMapping("customers/add")
    public String addCustomer(@ModelAttribute("customer") @Valid CustomerIncomeDto customerIncomeDto, @Valid CustomerDto customerDto, @Valid PropertyDto propertyDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
//            customerIncomeService.add(customerIncomeDto);
            customerService.add(customerDto, customerIncomeDto, propertyDto);
            return "advisor-panel";
        }
        return "advisor-panel";
    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @PutMapping("customers/update/{email}")
    public @ResponseBody
    String updateCustomer(@PathVariable(value = "email")
                          @RequestParam String email,
                          @RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String phone,
                          @RequestParam int age,
                          @RequestParam int kids,
                          @RequestParam String customerStatus,
                          @Valid CustomerDto customerDto, @Valid CustomerIncomeDto customerIncomeDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            CustomerDto customerDto1 = new CustomerDto();
            customerDto1.setAge(age);
            customerDto1.setCustomerStatus(customerStatus);
            customerDto1.setEmail(email);
            customerDto1.setFirstName(firstName);
            customerDto1.setLastName(lastName);
            customerDto1.setPhone(phone);
            customerDto1.setKids(kids);
            customerService.update(customerDto1, customerIncomeDto);
            return "advisor-panel";
        }
        return "customers";
    }


    @Secured({"ROLE_ADVISOR", "ROLE_CLIENT"})
    @DeleteMapping("customers/delete")
    public String deleteCustomer(@ModelAttribute("customer") @Valid CustomerDto customer) {
        customerService.delete(customer.getId());
        return "customers";
    }
}
