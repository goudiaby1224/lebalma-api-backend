package com.sn.lde.ngy.rest;

import com.sn.lde.ngy.model.Produit;
import com.sn.lde.ngy.utils.ConstantsPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(ConstantsPath.MAIN_LEBALMA_PATH+"produits/")
public class ProduitController {


    @GetMapping("/")
    ResponseEntity<Collection<Produit>> findAll(){
       return null;
    }
}
