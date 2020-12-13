package com.sn.lde.ngy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.repository.PartenaireRepository;

@Service
public class PartenaireService {

    private PartenaireRepository partenaireRepository;

    public PartenaireService(PartenaireRepository partenaireRepository) {
        super();
        this.partenaireRepository = partenaireRepository;
    }

    public void createPartenaire(Partenaire partenaire) {
        partenaireRepository.save(partenaire);
    }


    public Partenaire find(Long id) {
        return partenaireRepository.findById(id).get();
    }

    public List<Partenaire> findAll() {
        return partenaireRepository.findAll();
    }


    public void delete(Long id) {
        partenaireRepository.deleteById(id);
    }



    public void updatePartenaire(Partenaire partenaire) {
        Partenaire oldPartenaire = partenaireRepository.findById(partenaire.getId()).get();
        oldPartenaire.setAdresse(partenaire.getAdresse());
        partenaireRepository.save(oldPartenaire);
    }

}
