package com.netas.coop.FlexibleHours.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netas.coop.FlexibleHours.responses.UserResponse;
import com.netas.coop.FlexibleHours.services.UserService;

@RestController
@RequestMapping("api/v1.0/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

}
