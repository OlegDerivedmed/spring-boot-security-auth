package com.derivedmed.mytown.services;



import com.derivedmed.mytown.entities.User;
import com.derivedmed.mytown.form.UserForm;

import java.util.Optional;


public interface UserService {

    void createUser(UserForm userForm);
    Optional<User> findByLogin(String login);
    Optional<User> fingById(long id);
}
