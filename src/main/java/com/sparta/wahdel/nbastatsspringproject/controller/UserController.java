package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.UsersService;
import com.sparta.wahdel.nbastatsspringproject.utils.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/createAccount")
    public String createAccount() {
        return "createNewAccount";
    }

    //Todo: create view
    @PostMapping("/createAccount")
    public String newUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String confirmPassword,
                          @RequestParam String role) {
        if (usersService.getUserByUsername(username).isEmpty()) {
            if (InputValidator.isValidUsername(username)) {
                if (confirmPassword.equals(password)) {
                    usersService.saveUser(username, password, role);
                    return "index";
                }
            } else {
                System.out.println("Invalid Username");
            }
        } else {
            System.out.println("Username already exists");
        }
        return "redirect:/createAccount";
    }
}
