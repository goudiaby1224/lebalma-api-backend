package com.sn.lde.ngy.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sn.lde.ngy.model.ServiceOumou;
import com.sn.lde.ngy.service.ServiceOumouService;

@RestController
@RequestMapping("/serviceoumous")
public class ServiceOumouController {

    private ServiceOumouService serviceOumouService;

    public ServiceOumouController(ServiceOumouService serviceOumouService) {
        super();
        this.serviceOumouService = serviceOumouService;
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<ServiceOumou> findAll()
    {
        return serviceOumouService.findAll();
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public ServiceOumou findById(@PathVariable Long id) {
        return serviceOumouService.findById(id);
    }
    
    
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody ServiceOumou serviceOumou)
    {
        serviceOumouService.create(serviceOumou);
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody ServiceOumou serviceOumou) {
        serviceOumouService.update(serviceOumou);
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
      serviceOumouService.delete(id);
    }
}
