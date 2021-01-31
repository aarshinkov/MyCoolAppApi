package com.aarshinkov.rest.mycoolapp.controllers;

import com.aarshinkov.rest.mycoolapp.entities.UserEntity;
import com.aarshinkov.rest.mycoolapp.models.UserCreateModel;
import com.aarshinkov.rest.mycoolapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/login", params = {"username", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserEntity login(@RequestParam("username") String username,
            @RequestParam("password") String password) throws Exception {

        UserEntity user = usersRepository.findByUsername(username);

        if (user == null) {
            return null;
        }

        if (!password.equals(user.getPassword())) {
            return null;
//            throw new Exception("Password mismatch.");
        }

        return user;
    }

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean register(UserCreateModel ucm) {
        
        UserEntity user = new UserEntity();
        user.setUsername(ucm.getUsername());
        user.setPassword(ucm.getPassword());
        user.setGender(ucm.getGender());
        user.setFirstName(ucm.getFirstName());
        user.setLastName(ucm.getLastName());
        
        UserEntity createdUser = usersRepository.save(user);
        
        return createdUser != null;
        
//        return createdUser;
    }
}
