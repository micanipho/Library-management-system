package com.Library_management_system.controller;

import com.Library_management_system.model.Book;
import com.Library_management_system.model.User;
import com.Library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lms/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
       return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable Long userId) {
       return userService.getUser(userId);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
