package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.model.CustomerIncome;
import pl.sda.demo.repository.CustomerIncomeRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerIncomeService {
    private final CustomerIncomeRepository customerIncomeRepository;


    public Long add(CustomerIncomeDto customerIncomeDto) {
        CustomerIncome customerIncome1 = CustomerIncome.builder()
                .netIncome(customerIncomeDto.getNetIncome())
//                .isContractOfEmployment(customerIncomeDto.isContractOfEmployment())
//                .isIndefiniteContract(customerIncomeDto.isIndefiniteContract())
//                .isSelfEmployed(customerIncomeDto.isSelfEmployed())
//                .formOfSettlement(customerIncomeDto.getFormOfSettlement())
                .build();
        customerIncomeRepository.save(customerIncome1);
        return customerIncomeRepository.save(customerIncome1).getId();
    }

    public List<CustomerIncomeDto> findAll() {
        List<CustomerIncomeDto> customerIncomeDtoUser = new ArrayList<>();
        Iterable<CustomerIncome> customerIncomes = customerIncomeRepository.findAll();
        for (CustomerIncome customerIncomes2 : customerIncomes) {
            customerIncomeDtoUser.add(
                    CustomerIncomeDto.builder()
                            .netIncome(customerIncomes2.getNetIncome())
//                            .isContractOfEmployment(customerIncomes2.isContractOfEmployment())
//                            .isIndefiniteContract(customerIncomes2.isIndefiniteContract())
//                            .isSelfEmployed(customerIncomes2.isSelfEmployed())
//                            .formOfSettlement(customerIncomes2.getFormOfSettlement())
                            .build());
        }
        return customerIncomeDtoUser;


    }
}
