package com.sunglowsys.resources;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResources {
    private  final Logger logger = LoggerFactory.getLogger(CustomerResources.class);

    private final CustomerService customerService;

    public CustomerResources(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        logger.debug("REST request to create customer:{}",customer);
        Customer result = customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        logger.debug("REST request to update customer:{}",customer);
        if (customer.getId()==null) {
            throw new RuntimeException("id must not be null");
        }
        Customer result = customerService.update(customer);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/customers")
    public ResponseEntity<Page<Customer>> findAll(Pageable pageable) {
        logger.debug("REST request to findAll customer:{}",pageable);
        Page<Customer> result = customerService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Optional<Customer>> findOne(@PathVariable Long id) {
        logger.debug("REST request findOne customer:{}",id);
        Optional<Customer> result = customerService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        logger.debug("REST request to delete customer:{}",id);
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
