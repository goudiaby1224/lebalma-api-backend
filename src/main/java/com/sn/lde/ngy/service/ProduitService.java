package com.sn.lde.ngy.service;

import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.model.Produit;
import com.sn.lde.ngy.repository.PartenaireRepository;
import com.sn.lde.ngy.repository.ProduitRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final PartenaireRepository partenaireRepository;

    public ProduitService(final ProduitRepository produitRepository, final PartenaireRepository partenaireRepository) {
        this.produitRepository = produitRepository;
        this.partenaireRepository = partenaireRepository;
    }

    public Produit save(final Produit produit){
        //Partenaire partenaire = partenaireRepository.getOne(produit.get)
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
