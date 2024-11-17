package com.ktsoft.fashion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(
            @RequestBody User user) {
        User newUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return ResponseEntity.ok("Deleted successfully !");
        // return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully !");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable("id") long id) {
        User fetchUser = this.userService.fetchUserById(id);

        // return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
        return ResponseEntity.ok(fetchUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> fetchUser() {
        return ResponseEntity.ok(this.userService.fetchAllUser());
        // return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser());
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(
            @RequestBody User user) {
        User newUser = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok(newUser);
    }

}
