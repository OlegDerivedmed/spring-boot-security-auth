package com.derivedmed.mytown.controllers;

import com.derivedmed.mytown.entities.User;
import com.derivedmed.mytown.form.UserForm;
import com.derivedmed.mytown.repository.UserRepository;
import com.derivedmed.mytown.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") Long userId){
        return repository.getOne(userId);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody UserForm userForm){
        service.createUser(userForm);
        return ResponseEntity.ok().build();
    }
}
