package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.requests.ChangePasswordRequest;
import com.netas.coop.FlexibleHours.requests.CreateUserByAdminRequest;
import com.netas.coop.FlexibleHours.requests.UpdateUserRequest;
import com.netas.coop.FlexibleHours.responses.UserResponse;
import com.netas.coop.FlexibleHours.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/username/{username}")
    public UserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserByAdminRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest userRequest) {
        return userService.updateUser(userId, userRequest);
    }

    @PutMapping("/{userId}/change-password")
    public UserResponse changePassword(@PathVariable long userId, @RequestBody ChangePasswordRequest request) {
        return userService.changePassword(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}
