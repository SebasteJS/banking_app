package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    User user = new User();

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
        List<Customer> customerList = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAllById(Collections.singletonList(user.getId()));
        for (Customer customer2 : customers) {
            customerList.add(
                    Customer.builder()
                            .firstName(customer2.getFirstName())
                            .lastName(customer2.getLastName())
                            .phone(customer2.getPhone())
                            .email(customer2.getEmail())
                            .age(customer2.getAge())
                            .kids(customer2.getKids())
                            .customerStatus(customer2.getCustomerStatus())
                            .build());
            customerRepository.findById(customer2.getId());
        }
        return customerList;
    }

    public Long add(CustomerDto customer) {
        Customer user1 = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .age(customer.getAge())
                .kids(customer.getKids())
                .customerStatus(customer.getCustomerStatus())
                .build();
        customerRepository.save(user1);
        return user1.getId();
    }


    public void update(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerDto.getId());
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            customer.setPhone(customerDto.getPhone());
            customer.setAge(customerDto.getAge());
            customer.setEmail(customerDto.getEmail());
            customer.setKids(customerDto.getKids());
            customer.setCustomerStatus(customerDto.getCustomerStatus());
            customerRepository.save(customer);
        }
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}





