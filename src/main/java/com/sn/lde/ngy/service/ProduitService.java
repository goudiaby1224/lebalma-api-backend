package com.sn.lde.ngy.service;

import com.sn.lde.ngy.model.Produit;
import com.sn.lde.ngy.repository.ProduitRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(final ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit save(final Produit produit){
        return produitRepository.save(produit);
    }

    public Produit update(@NonNull final Produit produit){
        Produit dbproduit = produitRepository.findById(produit.getId()).orElseThrow();
        dbproduit.update(produit);
        return produitRepository.save(dbproduit);
    }

    public Produit findByProduitId(Long produitId){
        return produitRepository.findById(produitId).orElseThrow();
    }

    public Collection<Produit> findAll(){
       return produitRepository.findAll();
    }

    public Collection<Produit> findAllByPartenaireId(final Long partenaireId){
        return produitRepository.findByPartenaireId(partenaireId);
    }
}
