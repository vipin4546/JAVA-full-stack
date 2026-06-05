package com.vipin.usermanagement.controller;

import com.vipin.usermanagement.entity.User;
import com.vipin.usermanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user,
                           Model model) {

        service.saveUser(user);

        model.addAttribute(
                "message",
                "User Added Successfully"
        );

        return "success";
    }
}