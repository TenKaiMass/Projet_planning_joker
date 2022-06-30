package com.hitema.spring.boot.planning.controllers;


import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WelcomeController {

//    private UserService service;
//
//    public  WelcomeController(UserService service){
//        this.service = service;
//    }
//    @GetMapping
//    public String Root(ModelMap model){
//        User u = service.read(u.getId())
//        return "index";}
    @GetMapping("/admin")
    public String Admin(ModelMap model){
        return "index_admin";
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







}
