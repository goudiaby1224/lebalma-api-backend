package com.sn.lde.ngy.model;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="PRODUIT")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String code;
    @NonNull
    @Column(nullable = false)
    private String description;
    @OneToOne
    @NonNull
    private Partenaire partenaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit update(Produit produit){
        this.code = produit.getCode();
        this.description = produit.description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit)) return false;
        Produit produit = (Produit) o;
        return getId().equals(produit.getId()) && getCode().equals(produit.getCode()) && Objects.equals(getDescription(), produit.getDescription()) && partenaire.equals(produit.partenaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getDescription(), partenaire);
    }
}
