package pl.sda.demo.service;


import org.springframework.stereotype.Service;
import pl.sda.demo.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    private List<CustomerDto> customers = new ArrayList<>();

    public List<CustomerDto> list() {
        return customers;
    }

    public void add(CustomerDto customer) {
        customers.add(customer);
    }

    public void delete(Long id) {
        CustomerDto customerToDelete =

                customers.stream()
                        .filter(t -> t.getId().equals(id))
                        .collect(Collectors.toList()).get(0);
        customers.remove(customerToDelete);
    }
}
