package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getById(UUID id);

    CustomerDTO createCustomer(CustomerDTO beerDTO);

    void updateCustomer(UUID id, CustomerDTO customerDTO);

    void deleteById(UUID id);
}
