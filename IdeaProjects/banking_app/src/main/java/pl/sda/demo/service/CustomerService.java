package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final pl.sda.demo.repository.CustomerRepository CustomerRepository;


    public Long add(CustomerDto customerDto) {
        Customer customer1 = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .phone(customerDto.getPhone())
                .email(customerDto.getEmail())
                .age(customerDto.getAge())
                .kids(customerDto.getKids())
                .isProspect(customerDto.isProspect())
                .isCreditApplicationSubmitted(customerDto.isCreditApplicationSubmitted())
                .isCreditFinshed(customerDto.isCreditFinshed())
                .isInactive(customerDto.isInactive())
                .build();
        CustomerRepository.save(customer1);
        return CustomerRepository.save(customer1).getId();
    }

    public List<CustomerDto> findAll() {
        List<CustomerDto> CustomerDtoUser = new ArrayList<>();
        Iterable<Customer> customers = CustomerRepository.findAll();
        for (Customer customers2 : customers) {
            CustomerDtoUser.add(
                    CustomerDto.builder()
                            .firstName(customers2.getFirstName())
                            .lastName(customers2.getLastName())
                            .phone(customers2.getPhone())
                            .email(customers2.getEmail())
                            .kids(customers2.getKids())
                            .isProspect(customers2.isProspect())
                            .isCreditApplicationSubmitted(customers2.isCreditApplicationSubmitted())
                            .isCreditFinshed(customers2.isCreditFinshed())
                            .isInactive(customers2.isInactive())
                            .build());
        }
        return CustomerDtoUser;


    }
}
