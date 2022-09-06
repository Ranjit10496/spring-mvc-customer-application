package com.sunglowsys.resources;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResources {
    private final CustomerService customerService;

    public CustomerResources(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer result = customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer result = customerService.update(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/customers")
    public ResponseEntity<Page<Customer>> finalAll(Pageable pageable) {
        Page<Customer> result = customerService.finalAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Optional<Customer>> findOne(@PathVariable Long id) {
        Optional<Customer> result = customerService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
