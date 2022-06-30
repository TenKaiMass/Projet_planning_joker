package com.hitema.spring.boot.planning.controllers;


import com.hitema.spring.boot.planning.entities.Session;
import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.SessionService;
import com.hitema.spring.boot.planning.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {
    private static final Logger log = LoggerFactory.getLogger(SessionController.class);


    private SessionService service;

    private UserService userService;



    public  SessionController(SessionService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }




    @GetMapping("/{id}")
    Session getOne(@PathVariable("id") Long id){
        log.trace("Session Id :{}",id);
        return service.read(id);
    }

    @GetMapping("/session_responsable")
    public String SessionRespo(ModelMap model){
        model.addAttribute("users", userService.readAllMember());
        return "session_responsable";
    }


    @GetMapping("/add")
    public String addSession(ModelMap model) {
        Session session = new Session();
        model.addAttribute("session", session);
        return "add_session";
    }

    @PostMapping("/add")
    public String retrieveSession(@ModelAttribute("session") Session session) {
        /*session.setNom(nom);
        session.setUnites(unit);*/
        session.setCreationDate(LocalDateTime.now());
        log.info(session.toString());
        service.create(session);
        return "index_admin";
    }

    @PostMapping("/addUserToSession")
    public String retrieveUser(@ModelAttribute("user") User user) {
        //user.setPassword(mdp);
        log.info(user.toString());
        userService.create(user);
        return "index_admin";
    }




    
}
