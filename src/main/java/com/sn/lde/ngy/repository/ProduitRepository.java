package com.sn.lde.ngy.repository;

import com.sn.lde.ngy.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Query("select p from Produit p where p.partenaire.id = :partenaireId")
    Collection<Produit> findByPartenaireId(@Param("partenaireId") Long partenaireId);
}
