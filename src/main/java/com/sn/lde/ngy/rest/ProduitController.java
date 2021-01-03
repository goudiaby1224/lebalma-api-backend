package com.sn.lde.ngy.rest;

import com.sn.lde.ngy.model.Produit;
import com.sn.lde.ngy.service.ProduitService;
import com.sn.lde.ngy.utils.ConstantsPath;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping(ConstantsPath.MAIN_LEBALMA_PATH+"produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produit> save(@RequestBody Produit produit){
        return  ResponseEntity.ok(produitService.save(produit));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produit> update(@RequestBody Produit produit){
        return  ResponseEntity.ok(produitService.update(produit));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Produit>> findAll(){
        return ResponseEntity.ok(produitService.findAll());
    }

    @GetMapping( path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produit>  findbyId(@PathVariable("id") Long produitId){
        return ResponseEntity.ok(produitService.findByProduitId(produitId));
    }

    @GetMapping( value = "/partenaire/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Produit>>  findbPartenaireId(@PathVariable("id") Long partenaireId){
        return ResponseEntity.ok(produitService.findAllByPartenaireId(partenaireId));
    }

}
