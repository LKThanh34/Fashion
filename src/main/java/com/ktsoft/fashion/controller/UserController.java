package com.ktsoft.fashion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/user")
    public User createNewUser(
            @RequestBody User user) {

        User user2 = this.userService.handleCreateUser(user);

        return user2;

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(
            @PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "delete user";
    }

    @GetMapping("user/{id}")
    public User getUserById(
            @PathVariable("id") long id) {
        return this.userService.fetchUserById(id);
    }

    @GetMapping("user")
    public List<User> fetchUser() {
        return this.userService.fetchAllUser();
    }

    @PutMapping("/user")
    public User updateUser(
        @RequestBody User user
        ) {
    User Int_user = this.userService.handleUpdateUser(user);
    return Int_user;
}

}
