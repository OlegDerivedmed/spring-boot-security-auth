package com.derivedmed.mytown.services;
import com.derivedmed.mytown.entities.Role;
import com.derivedmed.mytown.entities.State;
import com.derivedmed.mytown.entities.User;
import com.derivedmed.mytown.form.UserForm;
import com.derivedmed.mytown.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void createUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .login(userForm.getLogin())
                .password(encoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        repository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return repository.findOneByLogin(login);
    }

    @Override
    public Optional<User> fingById(long id) {
        return repository.findById(id);
    }
}
