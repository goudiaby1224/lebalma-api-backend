package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.RoleConverter;
import com.sn.lde.ngy.model.Employe;
import com.sn.lde.ngy.model.Role;
import com.sn.lde.ngy.service.EmployeService;

@CrossOrigin
@RestController
@RequestMapping("/lebalma/employes")
public class EmployeController {

    private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        super();
        this.employeService = employeService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Employe find(@PathVariable Long id) {
        return employeService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/partenaire/{id}")
    public Employe findEmployees(@PathVariable Long id) {
        return employeService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Employe employe) {
        employeService.create(employe);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    public void update(@RequestBody Employe employe) {
        employeService.updateEmploye(employe);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(@PathVariable Long id) {
        employeService.delete(id);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Role.class, new RoleConverter());
    }

}
