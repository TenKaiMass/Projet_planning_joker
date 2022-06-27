package com.hitema.sakila.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
    @RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String index(ModelMap model){
        String message = "Nous sommes le "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
        model.addAttribute("message", message);
        return "index";
    }
}
