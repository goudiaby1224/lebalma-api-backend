package com.sn.lde.ngy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.UtilisateurOumou;
import com.sn.lde.ngy.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        super();
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<UtilisateurOumou> findAll() {
        return utilisateurRepository.findAll();
    }

    public UtilisateurOumou findById(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    public void create(UtilisateurOumou utilisateurOumou) {
        utilisateurRepository.save(utilisateurOumou);
    }

    public void uptdate(UtilisateurOumou utilisateurOumou) {
        UtilisateurOumou oldUtilisateurOumou = utilisateurRepository.findById(utilisateurOumou.getId()).get();

        oldUtilisateurOumou.setAdresse(utilisateurOumou.getAdresse());
        oldUtilisateurOumou.setMail(utilisateurOumou.getMail());
        oldUtilisateurOumou.setMatricule(utilisateurOumou.getMatricule());
        oldUtilisateurOumou.setMetier(utilisateurOumou.getMetier());
        oldUtilisateurOumou.setNom(utilisateurOumou.getNom());
        oldUtilisateurOumou.setNomUtilisateur(utilisateurOumou.getNomUtilisateur());
        oldUtilisateurOumou.setPrenom(utilisateurOumou.getPrenom());
        oldUtilisateurOumou.setRole(utilisateurOumou.getRole());
        oldUtilisateurOumou.setService(utilisateurOumou.getService());
        oldUtilisateurOumou.setTel(utilisateurOumou.getTel());

        utilisateurRepository.save(oldUtilisateurOumou);



    }

    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

}
