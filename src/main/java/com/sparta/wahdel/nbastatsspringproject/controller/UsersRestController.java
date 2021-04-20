package com.sparta.wahdel.nbastatsspringproject.controller;

import com.sparta.wahdel.nbastatsspringproject.entity.UsersEntity;
import com.sparta.wahdel.nbastatsspringproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {

    private final UsersService usersService;

    @Autowired
    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/rest/users")
    public Iterable<UsersEntity> findAll() {
        return usersService.getAllUsers();
    }

    @PostMapping("/rest/users")
    public UsersEntity newUser(@RequestBody UsersEntity usersEntity) {
        usersService.save(usersEntity);
        return usersEntity;
    }
}
