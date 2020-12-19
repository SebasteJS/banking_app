package pl.sda.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.demo.dto.BrokerDto;
import pl.sda.demo.dto.ClientDto;
import pl.sda.demo.model.Broker;
import pl.sda.demo.model.Client;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final pl.sda.demo.repository.ClientRepository ClientRepository;


    public Long add(ClientDto clientDto) {
        Client client1 = Client.builder()
                .companyName(clientDto.getCompanyName())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .login(clientDto.getLogin())
                .password(clientDto.getPassword())
                .build();
        ClientRepository.save(client1);
        return ClientRepository.save(client1).getId();
    }

    public List<ClientDto> findAll() {
        List<ClientDto> ClientdtoList = new ArrayList<>();
        Iterable<Client> clients = ClientRepository.findAll();
        for (Client client2 : clients) {
            ClientdtoList.add(
                    ClientDto.builder()
                            .companyName(client2.getCompanyName())
                            .firstName(client2.getFirstName())
                            .lastName(client2.getLastName())
                            .login(client2.getLogin())
                            .password(client2.getPassword())
                            .build());
        }
        return ClientdtoList;
    }
}
