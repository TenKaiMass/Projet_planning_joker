package com.hitema.spring.boot.planning.controllers;


import com.hitema.spring.boot.planning.entities.Session;
import com.hitema.spring.boot.planning.services.SessionService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
    @RequestMapping("/sessions")
        @CrossOrigin
public class SessionController {
    private static final Logger log = LoggerFactory.getLogger(SessionController.class);


    private SessionService service;

    public  SessionController(SessionService service){
        this.service = service;
    }

    @GetMapping({"","/session"})
    List<Session> readAll(){
        return service.readAll();
    }

    @GetMapping("/{id}")
    Session getOne(@PathVariable("id") Integer id){
        log.trace("Session Id :{}",id);
        return service.read(id);
    }
    @PostMapping("/index_responsable")
    Session create(@RequestBody Session session){
        log.trace("Create new Session : {}",session);
        return service.create(session);
    }


}
