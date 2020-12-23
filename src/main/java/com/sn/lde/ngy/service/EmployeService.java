package com.sn.lde.ngy.service;

import java.util.List;

import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.repository.PartenaireRepository;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.EmployePartenaire;
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


    public List<EmployePartenaire> findAll() {
        return employeRepository.findAll();
    }

    public void create(EmployePartenaire employePartenaire) {
        Partenaire partenaire = partenaireRepository.findById(employePartenaire.getPartenaire().getId()).orElseThrow();
        employePartenaire.setPartenaire(partenaire);
        employeRepository.save(employePartenaire);
    }

    public void updateEmploye(EmployePartenaire employePartenaire) {
        EmployePartenaire oldEmployePartenaire = employeRepository.findById(employePartenaire.getId()).orElseThrow();

        oldEmployePartenaire.setMail(employePartenaire.getMail());
        oldEmployePartenaire.setMatricule(employePartenaire.getMatricule());
        oldEmployePartenaire.setMetier(employePartenaire.getMetier());
        oldEmployePartenaire.setNom(employePartenaire.getNom());
        oldEmployePartenaire.setNomUtilisateur(employePartenaire.getNomUtilisateur());
        oldEmployePartenaire.setPartenaire(employePartenaire.getPartenaire());
        oldEmployePartenaire.setPrenom(employePartenaire.getPrenom());
        oldEmployePartenaire.setRole(employePartenaire.getRole());
        oldEmployePartenaire.setService(employePartenaire.getService());
        oldEmployePartenaire.setTel(employePartenaire.getTel());

        employeRepository.save(oldEmployePartenaire);
    }

    public void delete(Long id) {
        employeRepository.deleteById(id);
    }

    public EmployePartenaire findById(Long id) {
        return employeRepository.findById(id).orElseThrow();
    }

    public List<EmployePartenaire> findByPartenaireId(Long id) {
        return employeRepository.findByPartenaireId(id);
    }

}
