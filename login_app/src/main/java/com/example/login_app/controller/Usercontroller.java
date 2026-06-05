package com.example.login_app.controller;


import com.example.login_app.entity.User;
import com.example.login_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Usercontroller {
    private final UserService userService;

    public Usercontroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.registerUser(user);
        return "login";
    }

    @PostMapping("login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        User user = userService.login(email, password);
        if (user == null) {
            return "login";
        }

        return "dashboard";


    }

}
