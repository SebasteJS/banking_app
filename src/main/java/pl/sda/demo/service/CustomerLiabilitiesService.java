package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerLiabilitiesDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.Customer;
import pl.sda.demo.model.CustomerLiabilities;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerLiabilitiesService {
    private final pl.sda.demo.repository.CustomerLiabilitiesRepository CustomerLiabilitiesRepository;


    public Long add(CustomerLiabilitiesDto liabilitiesdto) {
        CustomerLiabilities liabilities1 = CustomerLiabilities.builder()
                .creditCards(liabilitiesdto.getCreditCards())
                .accountDebt(liabilitiesdto.getAccountDebt())
                .childSupport(liabilitiesdto.getChildSupport())
                .customer(new Customer())
                .build();
        CustomerLiabilitiesRepository.save(liabilities1);
        return CustomerLiabilitiesRepository.save(liabilities1).getId();
    }

    public List<CustomerLiabilitiesDto> findAll() {
        List<CustomerLiabilitiesDto> customerliab = new ArrayList<>();
        Iterable<CustomerLiabilities> liabilities = CustomerLiabilitiesRepository.findAll();
        for (CustomerLiabilities liabilities2 : liabilities) {
            customerliab.add(
                    CustomerLiabilitiesDto.builder()
                            .creditCards(liabilities2.getCreditCards())
                            .accountDebt(liabilities2.getAccountDebt())
                            .childSupport(liabilities2.getChildSupport())
                            .build());
        }
        return customerliab;


    }
}
