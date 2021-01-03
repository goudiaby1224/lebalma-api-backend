package com.sn.lde.ngy.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

@Table(name = "PARTENAIRE")
@Entity
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RAISONSOCIAL")
    private String raisonSocial;

    private String adresse;

    private String telephone;

    private String responsable;

    private String mail;
    @Column(name = "DATEMISEENSERVICE")
    private Date dateMiseEnService;

    @Enumerated(EnumType.STRING)
    private Types Type;

    @OneToMany
    private Collection<Produit> produits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public Types getType() {
        return Type;
    }

    public void setType(Types type) {
        Type = type;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
}
