package com.hitema.spring.boot.planning.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
    @RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String Login(ModelMap model){
        return "login";
    }

}
