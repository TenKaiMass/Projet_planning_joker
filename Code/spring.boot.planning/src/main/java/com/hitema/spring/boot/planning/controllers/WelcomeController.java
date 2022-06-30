package com.hitema.spring.boot.planning.controllers;



import com.hitema.spring.boot.planning.services.SessionService;
import com.hitema.spring.boot.planning.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class WelcomeController {


    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
    private UserService service;
    private  SessionService sessionService;

    public  WelcomeController(UserService service){
        this.service = service;
    }


    @GetMapping
    public String Login(ModelMap model){
        return "login";
    }


    @GetMapping("/admin")
    public String Admin(ModelMap model){
        return "index_admin";
    }

    @GetMapping("/membre")
    public String Membre(ModelMap model){
        return "index_membre";
    }

    @GetMapping("/responsable")
    public String Responsable(ModelMap model){
        return "session_responsable";
    }





}
