package com.hitema.sakila.controllers;

import com.hitema.sakila.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/countries")
public class CountryController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping({"","/list"})
    public String list(ModelMap model){
        log.trace("List all countries called ...");
        model.addAttribute("countries", service.readAll()) ;
        return "countries";
    }

}
