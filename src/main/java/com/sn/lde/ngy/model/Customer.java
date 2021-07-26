package com.sn.lde.ngy.model;

import javax.persistence.*;
import java.util.List;

@Table( name ="CUSTOMER" )
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    
    private String responsable;
    @OneToMany
    private List<UtilisateurOumou> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<UtilisateurOumou> getUserList() {
        return userList;
    }

    public void setUserList(List<UtilisateurOumou> userList) {
        this.userList = userList;
    }
}
