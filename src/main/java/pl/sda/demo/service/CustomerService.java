package pl.sda.demo.service;


import org.springframework.stereotype.Service;
import pl.sda.demo.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public List<Customer> list() {
        return customers;
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void delete(Long id) {
        Customer customerToDelete =

                customers.stream()
                        .filter(t -> t.getId().equals(id))
                        .collect(Collectors.toList()).get(0);
        customers.remove(customerToDelete);
    }
}
