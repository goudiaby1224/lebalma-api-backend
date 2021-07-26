package com.sn.lde.ngy.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sn.lde.ngy.model.Customer;
import com.sn.lde.ngy.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/stock/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<Customer> findAll()
    {
        return customerService.findAll();
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }
    
    
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Customer customer)
    {
        customerService.create(customer);
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
      customerService.delete(id);
    }
}
