package com.sn.lde.ngy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sn.lde.ngy.model.User;
import com.sn.lde.ngy.repository.UserReposistory;

@Service
public class UserService {

    private UserReposistory userRepository;

    public UserService(UserReposistory userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }


    public User find(Long id) {
        return userRepository.findById(id).get();
    }
    
    public User findByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }



    public void updateUser(User user) {
        User oldUser = userRepository.findById(user.getId()).get();
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
    }

}
