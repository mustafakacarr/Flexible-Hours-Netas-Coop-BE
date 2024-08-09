package com.netas.coop.FlexibleHours.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.netas.coop.FlexibleHours.entities.UserEntity;
import com.netas.coop.FlexibleHours.requests.*;
import com.netas.coop.FlexibleHours.responses.UserResponse;
import com.netas.coop.FlexibleHours.services.UserService;

@RestController
@RequestMapping("api/users")
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
/*
    @GetMapping("/username/{username}")
    public UserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }*/

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserByAdminRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest userRequest) {
        return userService.updateUser(userId, userRequest);
    }

    @PutMapping("/{userId}/change-password")
    public void changePassword(@PathVariable long userId, @RequestBody ChangePasswordRequest request) {
        userService.changePassword(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}
