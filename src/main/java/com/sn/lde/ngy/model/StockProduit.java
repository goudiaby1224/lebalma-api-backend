package com.sn.lde.ngy.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    @OneToOne
    private Produit produit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public StockProduit update(@NonNull StockProduit stockProduit) {
        this.quantite = stockProduit.getQuantite();
        this.produit = stockProduit.getProduit();
        return  this;
    }
}
