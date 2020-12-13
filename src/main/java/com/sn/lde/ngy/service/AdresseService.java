package com.sn.lde.ngy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.lde.ngy.model.Adresse;
import com.sn.lde.ngy.repository.AdresseRepository;

@Service
public class AdresseService {

    private AdresseRepository adresseRepository;

    public AdresseService(AdresseRepository adresseRepository) {
        super();
        this.adresseRepository = adresseRepository;
    }
    
   
    public void create (Adresse adresse)
    {
        adresseRepository.save(adresse);
    }
    
    public List<Adresse> findAll(){
        return adresseRepository.findAll();
    }
}
