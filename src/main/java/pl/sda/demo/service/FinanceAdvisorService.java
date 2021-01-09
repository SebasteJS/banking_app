package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.FinanceAdvisorDto;
import pl.sda.demo.model.FinanceAdvisor;
import pl.sda.demo.repository.FinancialAdvisorRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FinanceAdvisorService {

    private final FinancialAdvisorRepository financialAdvisorRepository;

    public Long add(FinanceAdvisorDto advisorDto) {
        FinanceAdvisor advisor1 = FinanceAdvisor.builder()
                .firstName(advisorDto.getFirstName())
                .lastName(advisorDto.getLastName())
                .login(advisorDto.getLogin())
                .password(advisorDto.getPassword())
                .build();
        financialAdvisorRepository.save(advisor1);
        return financialAdvisorRepository.save(advisor1).getId();
    }

    public List<FinanceAdvisorDto> findAll() {
        List<FinanceAdvisorDto> advisorDtoUser = new ArrayList<>();
        Iterable<FinanceAdvisor> advisors = financialAdvisorRepository.findAll();
        for (FinanceAdvisor advisors2 : advisors) {
            advisorDtoUser.add(
                    FinanceAdvisorDto.builder()
                            .firstName(advisors2.getFirstName())
                            .lastName(advisors2.getLastName())
                            .login(advisors2.getLogin())
                            .password(advisors2.getPassword())
                            .build());
        }
        return advisorDtoUser;


    }
}
