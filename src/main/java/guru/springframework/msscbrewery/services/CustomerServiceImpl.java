package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Zun")
                .build();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO beerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting customer with Id={}", id);
    }
}
