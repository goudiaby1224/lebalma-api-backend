package com.sn.lde.ngy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.lde.ngy.model.ServiceOumou;
import com.sn.lde.ngy.repository.ServiceOumouRepository;

@Service
public class ServiceOumouService {

    private ServiceOumouRepository serviceOumouRepository;

    public ServiceOumouService(ServiceOumouRepository serviceOumouRepository) {
        super();
        this.serviceOumouRepository = serviceOumouRepository;
    }
    
    public List<ServiceOumou> findAll()
    {
        return serviceOumouRepository.findAll();
    }
    
    public ServiceOumou findById(Long id) {
        
        return serviceOumouRepository.findById(id).get();
    }
    
    public void create(ServiceOumou serviceOumou)
    {
        serviceOumouRepository.save(serviceOumou);
    }
    
    public void update(ServiceOumou serviceOumou)
    {
        ServiceOumou oldService=serviceOumouRepository.findById(serviceOumou.getId()).get();
        
        oldService.setNom(serviceOumou.getNom());
        oldService.setResponsable(serviceOumou.getResponsable());
        
        serviceOumouRepository.save(oldService);
    }
    
    public void delete(Long id)
    
    {
       serviceOumouRepository.deleteById(id);
    }
}
