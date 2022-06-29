/*
package com.hitema.spring.boot.planning.controllers;

import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
@RequestMapping()
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public  UserController(UserService service){
        this.service = service;
    }

    @GetMapping({"","/list"})
    String list(ModelMap model){
        log.info("readAll user called ...");
        model.addAttribute("users",service.readAll());
        return "users";
    }





    @GetMapping("/{id}")
    User getOne(@PathVariable("id") Integer id){
        log.trace("User Id :{}",id);
        return service.read(id);
    }
    @PostMapping("/create")
    User create(@RequestBody User user){
        log.trace("Create new City : {}",user);
        return service.create(user);
    }


}
*/
