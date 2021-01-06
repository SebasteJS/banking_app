package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.dto.UserDto;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.model.Role;
import pl.sda.demo.model.User;
import pl.sda.demo.repository.RoleRepository;
import pl.sda.demo.role.RoleType;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerIncomeService {
    private final pl.sda.demo.repository.CustomerIncomeRepository CustomerIncomeRepository;


    public Long add(CustomerIncomeDto customerIncomeDto) {
        CustomerIncome customerIncome1 = CustomerIncome.builder()
                .netIncome(customerIncomeDto.getNetIncome())
                .isIndefiniteContract(customerIncomeDto.isIndefiniteContract())
                .isSelfEmployed(customerIncomeDto.isSelfEmployed())
                .build();
        CustomerIncomeRepository.save(customerIncome1);
        return CustomerIncomeRepository.save(customerIncome1).getId();
    }

    public List<CustomerIncomeDto> findAll() {
        List<CustomerIncomeDto> CustomerIncomeDtoUser = new ArrayList<>();
        Iterable<CustomerIncome> customerIncomes = CustomerIncomeRepository.findAll();
        for (CustomerIncome customerIncomes2 : customerIncomes) {
            CustomerIncomeDtoUser.add(
                    CustomerIncomeDto.builder()
                            .netIncome(customerIncomes2.getNetIncome())
                            .isIndefiniteContract(customerIncomes2.isIndefiniteContract())
                            .isSelfEmployed(customerIncomes2.isSelfEmployed())
                            .build());
        }
        return CustomerIncomeDtoUser;


    }
}
