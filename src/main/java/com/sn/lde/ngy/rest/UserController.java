package com.sn.lde.ngy.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.sn.lde.ngy.converter.RoleConverter;
import com.sn.lde.ngy.model.Role;
import com.sn.lde.ngy.model.User;
import com.sn.lde.ngy.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/lebalma/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public User find(@PathVariable Long id) {
        return userService.find(id);
    }
    
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/connexion/{login}")
    public User findByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Role.class, new RoleConverter());
    }
}
