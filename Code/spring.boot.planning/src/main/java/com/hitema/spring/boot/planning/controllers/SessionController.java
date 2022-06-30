package com.hitema.spring.boot.planning.controllers;


import com.hitema.spring.boot.planning.entities.Session;
import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.SessionService;
import com.hitema.spring.boot.planning.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/session_responsable")
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

    @GetMapping("/session")
    public String SessionRespo(ModelMap model){
        log.info("sessionResponsable");
        List<User> users = userService.readAllMember();
        log.info("All users ... : {}",users);
        model.addAttribute("users", users);
        log.info("All users loaded");
        List<Session> sessions = service.readAll();
        log.info("All Sessions ... : {}",sessions);
        model.addAttribute("sess",sessions);
        log.info("All sessions loaded");
        return "session_responsable";
    }


    @GetMapping("/session/add")
    public String addSession(ModelMap model) {
        log.info("addsesssion");
        Session session = new Session();
        model.addAttribute("session", session);
        return "add_session";
    }

    @PostMapping("/session/add")
    public String retrieveSession(@ModelAttribute("session") Session session) {
        session.setCreationDate(LocalDateTime.now());
        log.info(session.toString());
        service.create(session);
        return "redirect:/session_responsable/session";
    }

    @PostMapping("/session/addUserToSession")
    public String retrieveUser(@ModelAttribute("user") User user) {
        //user.setPassword(mdp);
        log.info(user.toString());
        userService.create(user);
        return "session_responsable";
    }





}
