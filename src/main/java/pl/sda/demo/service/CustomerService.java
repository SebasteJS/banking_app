package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.dto.PropertyDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.model.Property;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.CustomerIncomeRepository;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.repository.PropertyRepository;
import pl.sda.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerIncomeRepository customerIncomeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PropertyRepository propertyRepository;

    Customer customer;
    CustomerIncome customerIncome;
    Property property;

    public List<CustomerDto> listCustomers() {
        List<CustomerDto> customerDtoCustomer = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customers2 : customers) {
            customerDtoCustomer.add(
                    CustomerDto.builder()
                            .firstName(customers2.getFirstName())
                            .lastName(customers2.getLastName())
                            .phone(customers2.getPhone())
                            .email(customers2.getEmail())
                            .age(customers2.getAge())
                            .kids(customers2.getKids())
                            .build());
        }
        return customerDtoCustomer;
    }

    public List<Customer> findCustomersForUser() {
        User currentUser = getCurrentUser();
        List<Customer> customersList;
        customersList = currentUser.getCustomers();
        return customersList;
    }

    public Long add(CustomerDto customerDto, CustomerIncomeDto customerIncomeDto, PropertyDto propertyDto) {
        customerIncome = CustomerIncome.builder()
                .netIncome(customerIncomeDto.getNetIncome())
                .isContractOfEmployment(customerIncomeDto.isContractOfEmployment())
                .isIndefiniteContract(customerIncomeDto.isIndefiniteContract())
                .isSelfEmployed(customerIncomeDto.isSelfEmployed())
                .formOfSettlement(customerIncomeDto.getFormOfSettlement())
                .build();
        customerIncomeRepository.save(customerIncome);

        property = Property.builder()
                .isFlat(propertyDto.getIsFlat())
                .marketOfTransaction(propertyDto.getMarketOfTransaction())
                .ownership(propertyDto.getOwnership())
                .price(propertyDto.getPrice())
                .build();
        propertyRepository.save(property);

        customer = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .phone(customerDto.getPhone())
                .email(customerDto.getEmail())
                .age(customerDto.getAge())
                .kids(customerDto.getKids())
                .customerStatus(customerDto.getCustomerStatus())
                .customerIncome(customerIncome)
                .property(property)
                .build();
        customerRepository.save(customer);

        User currentUser = getCurrentUser();
        userService.updateCustomerList(currentUser, customer);
        return customer.getId();
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List<User> users = userRepository.findAll();
        return findCurrentUser(name, users);
    }

    private User findCurrentUser(String name, List<User> users) {
        User currentUser = new User();
        for (User user : users) {
            if (user.getLogin().equals(name)) {
                currentUser = user;
            }
        }
        return currentUser;
    }


    public void update(CustomerDto customerDto, CustomerIncomeDto customerIncomeDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerDto.getId());
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customer.setPhone(customerDto.getPhone());
            customer.setEmail(customerDto.getEmail());
            customer.setAge(customerDto.getAge());
            customer.setKids(customerDto.getKids());
            customer.setCustomerStatus(customerDto.getCustomerStatus());
            customer.setCustomerIncome(customerIncome);
            customerRepository.save(customer);
        }
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}





