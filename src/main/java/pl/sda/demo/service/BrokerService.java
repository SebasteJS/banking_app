package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.BrokerDto;
import pl.sda.demo.repository.BrokerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrokerService {

    private final BrokerRepository brokerRepository;
    private List<BrokerDto> brokers = new ArrayList<>();

    public List<BrokerDto> list() {
        brokerRepository.findAll();
        return brokers;
    }

    public void add(BrokerDto broker) {
        brokers.add(broker);
    }

    public void delete(Long id) {
        BrokerDto brokerToDelete =

                brokers.stream()
                        .filter(t -> t.getId().equals(id))
                        .collect(Collectors.toList()).get(0);
        brokers.remove(brokerToDelete);
    }
}
