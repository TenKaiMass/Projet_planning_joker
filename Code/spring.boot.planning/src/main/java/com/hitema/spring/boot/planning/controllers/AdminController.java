package com.hitema.spring.boot.planning.controllers;

import com.hitema.spring.boot.planning.entities.User;
import com.hitema.spring.boot.planning.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    private UserService service;

    public  AdminController(UserService service){
        this.service = service;
    }

    @GetMapping("/add")
    public String AddUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

/*    @GetMapping("/remove")
    public String RemoveUser(ModelMap model) {
        log.info("readAll user called ...");
        model.addAttribute("users", service.readAll());
        return "remove_user";
    }*/
    @PostMapping("/add")
    public String retrieveUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String mdp = encoder.encode(user.getNom());
        user.setPassword(mdp);
        log.info(user.toString());
        service.create(user);
        return "redirect:/admin";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        log.info("deleting user...");
        log.info(String.valueOf(id));
        service.delete(id);
        log.info("user deleted");
        return "redirect:/admin";
    }

/*    @GetMapping("/update")
    public String updateUser(ModelMap model) {
        log.info("readAll user called ...");
        model.addAttribute("users", service.readAllMember());
        return "update_role";
    }*/

    @GetMapping("/updateMyUser/{id}")
    public String updateMyUser(@PathVariable("id") Long id, Model model){
        User u = service.read(id);
        u.setRole("responsable");
        service.update(u);
        return "redirect:/admin";
    }
}
