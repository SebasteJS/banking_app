package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.CustomerIncomeRepository;
import pl.sda.demo.repository.CustomerRepository;
import pl.sda.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
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

    private final List<Long> listaId = new ArrayList<>();
    private List<Customer> customerListIds = new ArrayList<>();
    public List<Customer> userCustomers = new ArrayList<>();




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
    CustomerIncome customerIncome;


    public Long add(CustomerDto customerDto, CustomerIncomeDto customerIncomeDto) {
        customerIncome = CustomerIncome.builder()
                .netIncome(customerIncomeDto.getNetIncome())
                .isContractOfEmployment(customerIncomeDto.isContractOfEmployment())
                .isIndefiniteContract(customerIncomeDto.isIndefiniteContract())
                .isSelfEmployed(customerIncomeDto.isSelfEmployed())
                .formOfSettlement(customerIncomeDto.getFormOfSettlement())
                .build();
        customerIncomeRepository.save(customerIncome);

        customer1 = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .phone(customerDto.getPhone())
                .email(customerDto.getEmail())
                .age(customerDto.getAge())
                .kids(customerDto.getKids())
                .customerStatus(customerDto.getCustomerStatus())
                .customerIncome(customerIncome)
//                .customerIncome(customerIncome1)
                .build();
        userCustomers.add(customer1);

        customerRepository.save(customer1);

        Optional<User> user = userRepository.findById(6l);
        userService.updateCustomerList(user, userCustomers);


        return customer1.getId();
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





