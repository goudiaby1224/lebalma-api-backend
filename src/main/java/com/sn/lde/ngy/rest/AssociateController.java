package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.TypesConverter;
import com.sn.lde.ngy.model.Partenaire;
import com.sn.lde.ngy.model.Types;
import com.sn.lde.ngy.service.PartenaireService;

@CrossOrigin
@RestController
@RequestMapping("/stock/associates")
public class AssociateController {

    private PartenaireService partenaireService;

    public AssociateController(PartenaireService partenaireService) {
        super();
        this.partenaireService = partenaireService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Partenaire partenaire) {
        partenaireService.createPartenaire(partenaire);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Partenaire partenaire) {
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
