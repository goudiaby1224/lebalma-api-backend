package com.sn.lde.ngy.rest;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sn.lde.ngy.model.Adresse;
import com.sn.lde.ngy.service.AdresseService;

@RestController
@RequestMapping("/adresses")
public class AdresseController {
    
    private AdresseService adresseService;
    
    

    public AdresseController(AdresseService adresseService) {
        super();
        this.adresseService = adresseService;
    }

    public AdresseService getAdresseService() {
        return adresseService;
    }

    public void setAdresseService(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Adresse adresse) {
        adresseService.create(adresse);
    }
    
    @ResponseStatus(code =HttpStatus.OK )
    @GetMapping
    public List<Adresse> findAll(){
        return adresseService.findAll();
    }

}
