package com.Library_management_system.controller;

import com.Library_management_system.model.User;
import com.Library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('user:write')")
    public List<User> getUsers() {
       return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:read')")
    public User getUser(@PathVariable Long userId) {
       return userService.getUser(userId);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
