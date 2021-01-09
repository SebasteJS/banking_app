package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CreditDto;
import pl.sda.demo.model.Credit;
import pl.sda.demo.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final pl.sda.demo.repository.CreditRepository CreditRepository;


    public Long add(CreditDto creditDto) {
        Credit credit1 = Credit.builder()
                .loanAmmount(creditDto.getLoanAmount())
                .creditPeriod(creditDto.getCreditPeriod())
                .customer(new Customer())
                .build();
        CreditRepository.save(credit1);
        return CreditRepository.save(credit1).getId();
    }

    public List<CreditDto> findAll() {
        List<CreditDto> creditDtoList = new ArrayList<>();
        Iterable<Credit> credits = CreditRepository.findAll();
        for (Credit credit2 : credits) {
            creditDtoList.add(
                    CreditDto.builder()
                            .loanAmount(credit2.getLoanAmmount())
                            .creditPeriod(credit2.getCreditPeriod())
                            .build());
        }
        return creditDtoList;


    }
}
