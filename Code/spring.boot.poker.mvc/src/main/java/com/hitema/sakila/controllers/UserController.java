package com.hitema.sakila.controllers;

import com.hitema.sakila.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private RoleService service;

    public UserController(RoleService service) {
        this.service = service;
    }

    @GetMapping({"","/list"})
    public String list(ModelMap model){
        log.trace("List all users called ...");
        model.addAttribute("users", service.readAll()) ;
        return "users";
    }

}
