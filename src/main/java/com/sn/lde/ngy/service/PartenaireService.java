package com.sn.lde.ngy.service;

import java.util.List;
import java.util.Optional;

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
        Optional<Partenaire> optPartenaire = partenaireRepository.findById(id);
        return optPartenaire.orElse(new Partenaire());
    }

    public List<Partenaire> findAll() {
        return partenaireRepository.findAll();
    }

    public void delete(Long id) {
        partenaireRepository.deleteById(id);
    }

    public void updatePartenaire(Partenaire partenaire) {
        Optional<Partenaire> optionalPartenaire = partenaireRepository.findById(partenaire.getId());
        optionalPartenaire.ifPresent(dbPartenaire -> {
            dbPartenaire.setAdresse(partenaire.getAdresse());
            partenaireRepository.save(dbPartenaire);
        });
    }

}
