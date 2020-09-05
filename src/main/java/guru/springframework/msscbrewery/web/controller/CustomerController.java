package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id){
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDTO beerDTO){
        CustomerDTO customer = customerService.createCustomer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customers/" + customer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable UUID id, @Valid @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable UUID id){
        customerService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(i -> {
//            errors.add(i.getPropertyPath() + " : " + i.getMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

}
