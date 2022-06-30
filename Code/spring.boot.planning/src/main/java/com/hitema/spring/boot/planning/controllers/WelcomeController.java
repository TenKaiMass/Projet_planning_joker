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
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;

@Controller
public class WelcomeController {


    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
    private UserService service;
    private SessionService sessionService;

    public WelcomeController(UserService service, SessionService sessionService) {
        this.service = service;
        this.sessionService = sessionService;
    }

    @GetMapping("/admin")
    public String Admin(ModelMap model) {
        model.addAttribute("users", service.readAll());
        return "index_admin";
    }

    @GetMapping("/membre")
    public String Membre(ModelMap model) {
        return "index_membre";
    }

    @GetMapping("/session_")
    public String Responsable(ModelMap model) {
        return "session_responsable";
    }


}
