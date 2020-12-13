package com.sn.lde.ngy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.Employe;
import com.sn.lde.ngy.repository.EmployeRepository;

@Service
public class EmployeService {

    private EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        super();
        this.employeRepository = employeRepository;
    }


    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    public void create(Employe employe) {
        employeRepository.save(employe);
    }

    public void updateEmploye(Employe employe) {
        Employe oldEmploye = employeRepository.findById(employe.getId()).get();

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
        return employeRepository.findById(id).get();
    }

}
