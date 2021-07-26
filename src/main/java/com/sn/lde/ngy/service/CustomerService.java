package com.sn.lde.ngy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.lde.ngy.model.Customer;
import com.sn.lde.ngy.repository.ServiceOumouRepository;

@Service
public class CustomerService {

    private ServiceOumouRepository serviceOumouRepository;

    public CustomerService(ServiceOumouRepository serviceOumouRepository) {
        super();
        this.serviceOumouRepository = serviceOumouRepository;
    }
    
    public List<Customer> findAll()
    {
        return serviceOumouRepository.findAll();
    }
    
    public Customer findById(Long id) {
        
        return serviceOumouRepository.findById(id).get();
    }
    
    public void create(Customer customer)
    {
        serviceOumouRepository.save(customer);
    }
    
    public void update(Customer customer)
    {
        Customer oldService=serviceOumouRepository.findById(customer.getId()).get();
        
        oldService.setNom(customer.getNom());
        oldService.setResponsable(customer.getResponsable());
        
        serviceOumouRepository.save(oldService);
    }
    
    public void delete(Long id)
    
    {
       serviceOumouRepository.deleteById(id);
    }
}
