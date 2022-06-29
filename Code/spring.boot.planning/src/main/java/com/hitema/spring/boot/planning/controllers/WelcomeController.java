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

    @GetMapping("/admin")
    public String Admin(ModelMap model){
        return "index_admin";
    }

    @GetMapping("/id_respo")
    public String Respo(ModelMap model){
        return "index_responsable";
    }
    @GetMapping("/session")
    public String Session(ModelMap model){
        return "session_point";
    }

    @GetMapping("/membre")
    public String Membre(ModelMap model){
        return "index_membre";
    }
    @GetMapping("/responsable")
    public String Responsable(ModelMap model){
        return "index_responsable";
    }

    @GetMapping("/session_responsable")
    public String SessionRespo(ModelMap model){
        return "session_responsable";
    }





}
