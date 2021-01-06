package pl.sda.demo.service;



import org.springframework.stereotype.Service;
import pl.sda.demo.dto.BrokerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrokerService {


    private List<BrokerDto> brokers = new ArrayList<>();

    public List<BrokerDto> list() {
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
