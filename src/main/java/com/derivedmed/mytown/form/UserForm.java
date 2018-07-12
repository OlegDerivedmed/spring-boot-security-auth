package com.derivedmed.mytown.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Oleg Derivedmed on 05.07.2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
}
