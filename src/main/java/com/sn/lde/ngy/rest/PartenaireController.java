package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sn.lde.ngy.converter.TypesConverter;
import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.model.Types;
import com.sn.lde.ngy.service.PartenaireService;

@RestController
@RequestMapping("/lebalma/partenaires")
public class PartenaireController {

    private PartenaireService partenaireService;

    public PartenaireController(PartenaireService partenaireService) {
        super();
        this.partenaireService = partenaireService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createPartenaire(@RequestBody Partenaire partenaire) {
        partenaireService.createPartenaire(partenaire);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePartenaire(@RequestBody Partenaire partenaire) {
        partenaireService.updatePartenaire(partenaire);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Partenaire find(@PathVariable Long id) {
        return partenaireService.find(id);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partenaireService.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<Partenaire> findAll() {
        return partenaireService.findAll();
    }


    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Types.class, new TypesConverter());
    }
}
