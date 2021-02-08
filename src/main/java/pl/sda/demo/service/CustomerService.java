package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.repository.CustomerIncomeRepository;
import pl.sda.demo.repository.CustomerRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerIncomeRepository customerIncomeRepository;

    private final List<Long> listaId = new ArrayList<>();
    private List<Customer> customerListIds = new ArrayList<>();


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


    List<Customer> customerList = new ArrayList<>();

    public List<Customer> findCustomersForUser() {

        Iterable<Customer> customers = customerRepository.findAllById(listaId);
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
        }


        customerList = customerRepository.findAll(); //dfodaje wszystkich customerów, a nie tylko należących do usera


        if (customer1 != null) {

            listaId.add(customer1.getId());
            customerListIds = customerRepository.findAllById(listaId);

            if (!customerList.contains(customer1)) {
                customerListIds.addAll(customerList);
                System.out.println("Lista customerListIds");
                System.out.println(customerListIds);
                return customerListIds;
            } else
                return customerListIds;

        } else
            return customerList;
    }


    Customer customer1;
    CustomerIncome customerIncome1;

    public Long add(CustomerDto customer) {
//        customerIncome1 = CustomerIncome.builder()
//                .netIncome(customerIncomeDto.getNetIncome())
//                .build();
//        customerIncomeRepository.save(customerIncome1);



        customer1 = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .age(customer.getAge())
                .kids(customer.getKids())
                .customerStatus(customer.getCustomerStatus())
                .customerIncome(customer.getCustomerIncome())
//                .customerIncome(customerIncome1)
                .build();
        customerRepository.save(customer1);
        return customer1.getId();
    }


    public void update(CustomerDto customerDto) {
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
            customer.setCustomerIncome(customerDto.getCustomerIncome());
            customerRepository.save(customer);
        }
    }

    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}





