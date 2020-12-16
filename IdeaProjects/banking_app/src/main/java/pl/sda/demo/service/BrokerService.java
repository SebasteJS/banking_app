package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.BrokerDto;
import pl.sda.demo.model.Broker;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BrokerService {

    private final pl.sda.demo.repository.BrokerRepository BrokerRepository;


    public Long add(BrokerDto brokerDto) {
        Broker broker1 = Broker.builder()
                .companyName(brokerDto.getCompanyName())
                .firstName(brokerDto.getFirstName())
                .lastName(brokerDto.getLastName())
                .phone(brokerDto.getPhone())
                .email(brokerDto.getEmail())
                .build();
        BrokerRepository.save(broker1);
        return BrokerRepository.save(broker1).getId();
    }

    public List<BrokerDto> findAll() {
        List<BrokerDto> BrokerdtoList = new ArrayList<>();
        Iterable<Broker> brokers = BrokerRepository.findAll();
        for (Broker brokers2 : brokers) {
            BrokerdtoList.add(
                    BrokerDto.builder()
                            .companyName(brokers2.getCompanyName())
                            .firstName(brokers2.getFirstName())
                            .lastName(brokers2.getLastName())
                            .phone(brokers2.getPhone())
                            .email(brokers2.getEmail())
                            .build());
        }
        return BrokerdtoList;


    }
}
