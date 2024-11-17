package com.ktsoft.fashion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ktsoft.fashion.domain.User;
import com.ktsoft.fashion.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public User createNewUser(
        @RequestBody User user
    ) {

        User user2 = this.userService.handleCreateUser(user);

       return user2;

    }

}
