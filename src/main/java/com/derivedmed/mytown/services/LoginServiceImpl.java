package com.derivedmed.mytown.services;

import com.derivedmed.mytown.dto.TokenDto;
import com.derivedmed.mytown.entities.Token;
import com.derivedmed.mytown.entities.User;
import com.derivedmed.mytown.form.LoginForm;
import com.derivedmed.mytown.repository.TokensRepository;
import com.derivedmed.mytown.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = userRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()){
            var user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(),user.getPassword())){
                var token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(64,true,true))
                        .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        }
        throw new IllegalArgumentException("user not found");
    }
}
