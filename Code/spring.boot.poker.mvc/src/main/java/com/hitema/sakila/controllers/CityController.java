package com.hitema.sakila.controllers;

import com.hitema.sakila.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/cities")
public class CityController {

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping({"","/list"})
    public String list(ModelMap model){
        log.trace("List all cities called ...");
        model.addAttribute("cities", service.readAll()) ;
        return "cities";
    }

}
