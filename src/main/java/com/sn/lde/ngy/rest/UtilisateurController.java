package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.RoleConverter;
import com.sn.lde.ngy.model.Role;
import com.sn.lde.ngy.model.UtilisateurOumou;
import com.sn.lde.ngy.service.UtilisateurService;

@CrossOrigin
@RestController
@RequestMapping("/lebalma/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(final UtilisateurService utilisateurService) {
        super();
        this.utilisateurService = utilisateurService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<UtilisateurOumou> find() {
        return utilisateurService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public UtilisateurOumou findById(@PathVariable Long id) {
        return utilisateurService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public void create(@RequestBody UtilisateurOumou utilisateurOumou) {
        utilisateurService.create(utilisateurOumou);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    public void update(@RequestBody UtilisateurOumou utilisateurOumou) {
        utilisateurService.uptdate(utilisateurOumou);
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
