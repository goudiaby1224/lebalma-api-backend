package com.sn.lde.ngy.repository;

import com.sn.lde.ngy.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    Collection<Produit> findByPartenaireId(Long partenaireId);
}
