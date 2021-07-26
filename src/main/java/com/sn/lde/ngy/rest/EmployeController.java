package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.RoleConverter;
import com.sn.lde.ngy.model.EmployePartenaire;
import com.sn.lde.ngy.model.Role;
import com.sn.lde.ngy.service.EmployeService;

@CrossOrigin
@RestController
@RequestMapping("/stock/employes")
class EmployeController {

    private EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        super();
        this.employeService = employeService;
    }
    @CrossOrigin()
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<EmployePartenaire> findAll() {
        return employeService.findAll();
    }
    
    @CrossOrigin()
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public EmployePartenaire find(@PathVariable Long id) {
        return employeService.findById(id);
    }
    
    @CrossOrigin()
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/partenaire/{id}")
    public List<EmployePartenaire> findEmployees(@PathVariable Long id) {
        return employeService.findByPartenaireId(id);
    }
    
    @CrossOrigin()
    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody EmployePartenaire employePartenaire) {
        employeService.create(employePartenaire);
    }
    
    @CrossOrigin()
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    public void update(@RequestBody EmployePartenaire employePartenaire) {
        employeService.updateEmploye(employePartenaire);
    }
    
    @CrossOrigin()
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
