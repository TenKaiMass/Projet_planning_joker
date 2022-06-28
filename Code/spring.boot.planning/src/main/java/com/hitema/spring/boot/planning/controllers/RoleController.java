package com.hitema.spring.boot.planning.controllers;

import com.hitema.spring.boot.planning.entities.Role;
import com.hitema.spring.boot.planning.services.RoleService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
    @RequestMapping("/roles")
        @CrossOrigin
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private RoleService service;

    public  RoleController(RoleService service){
        this.service = service;
    }

    @GetMapping({"","/AllRole"})
    List<Role> readAll(){
        return service.readAll();
    }

    @GetMapping("/{idr}")
    Role getOne(@PathVariable("id") Integer id){
        log.trace("Session Id :{}",id);
        return service.read(id);
    }
    @PostMapping("/createSession")
    Role create(@RequestBody Role role){
        log.trace("Create new Session : {}",role);
        return service.create(role);
    }

}
