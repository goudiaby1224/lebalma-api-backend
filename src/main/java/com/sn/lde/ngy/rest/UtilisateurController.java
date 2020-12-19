package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.RoleConverter;
import com.sn.lde.ngy.model.Role;
import com.sn.lde.ngy.model.Utilisateur;
import com.sn.lde.ngy.service.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("/lebalma/utilisateurs")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        super();
        this.utilisateurService = utilisateurService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<Utilisateur> find() {
        return utilisateurService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public void create(@RequestBody Utilisateur utilisateur) {
        utilisateurService.create(utilisateur);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    public void update(@RequestBody Utilisateur utilisateur) {
        utilisateurService.uptdate(utilisateur);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Role.class, new RoleConverter());
    }
}
