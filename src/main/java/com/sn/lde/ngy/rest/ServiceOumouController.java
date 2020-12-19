package com.sn.lde.ngy.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.sn.lde.ngy.model.ServiceOumou;
import com.sn.lde.ngy.service.ServiceOumouService;

@CrossOrigin
@RestController
@RequestMapping("/lebalma/serviceoumous")
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
