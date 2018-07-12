package com.derivedmed.mytown.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Oleg Derivedmed on 05.07.2018
 */
@Controller
public class MainController {

    @GetMapping("/main")
    public String getMainPage(){
        return "main";
    }
    @GetMapping("/")
    public String getMain(){
        return "main";
    }
}
