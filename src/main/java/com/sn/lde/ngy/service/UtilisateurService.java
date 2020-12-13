package com.sn.lde.ngy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.Utilisateur;
import com.sn.lde.ngy.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        super();
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    public void create(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public void uptdate(Utilisateur utilisateur) {
        Utilisateur oldUtilisateur = utilisateurRepository.findById(utilisateur.getId()).get();

        oldUtilisateur.setAdresse(utilisateur.getAdresse());
        oldUtilisateur.setMail(utilisateur.getMail());
        oldUtilisateur.setMatricule(utilisateur.getMatricule());
        oldUtilisateur.setMetier(utilisateur.getMetier());
        oldUtilisateur.setNom(utilisateur.getNom());
        oldUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
        oldUtilisateur.setPrenom(utilisateur.getPrenom());
        oldUtilisateur.setRole(utilisateur.getRole());
        oldUtilisateur.setService(utilisateur.getService());
        oldUtilisateur.setTel(utilisateur.getTel());

        utilisateurRepository.save(oldUtilisateur);



    }

    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

}
