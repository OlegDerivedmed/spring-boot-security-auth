package com.derivedmed.mytown.services;

import com.derivedmed.mytown.dto.TokenDto;
import com.derivedmed.mytown.form.LoginForm;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
public interface LoginService {

    TokenDto login(LoginForm loginForm);
}
