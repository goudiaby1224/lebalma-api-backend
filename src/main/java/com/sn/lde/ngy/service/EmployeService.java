package com.sn.lde.ngy.service;

import java.util.List;

import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.repository.PartenaireRepository;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.Employe;
import com.sn.lde.ngy.repository.EmployeRepository;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;
    private final PartenaireRepository partenaireRepository;

    public EmployeService(final EmployeRepository employeRepository, PartenaireRepository partenaireRepository) {
        super();
        this.employeRepository = employeRepository;
        this.partenaireRepository = partenaireRepository;
    }


    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    public void create(Employe employe) {
        Partenaire partenaire = partenaireRepository.findById(employe.getPartenaire().getId()).orElseThrow();
        employe.setPartenaire(partenaire);
        employeRepository.save(employe);
    }

    public void updateEmploye(Employe employe) {
        Employe oldEmploye = employeRepository.findById(employe.getId()).orElseThrow();

        oldEmploye.setMail(employe.getMail());
        oldEmploye.setMatricule(employe.getMatricule());
        oldEmploye.setMetier(employe.getMetier());
        oldEmploye.setNom(employe.getNom());
        oldEmploye.setNomUtilisateur(employe.getNomUtilisateur());
        oldEmploye.setPartenaire(employe.getPartenaire());
        oldEmploye.setPrenom(employe.getPrenom());
        oldEmploye.setRole(employe.getRole());
        oldEmploye.setService(employe.getService());
        oldEmploye.setTel(employe.getTel());

        employeRepository.save(oldEmploye);
    }

    public void delete(Long id) {
        employeRepository.deleteById(id);
    }

    public Employe findById(Long id) {
        return employeRepository.findById(id).orElseThrow();
    }

    public List<Employe> findByPartenaireId(Long id) {
        return employeRepository.findByPartenaireId(id);
    }

}
