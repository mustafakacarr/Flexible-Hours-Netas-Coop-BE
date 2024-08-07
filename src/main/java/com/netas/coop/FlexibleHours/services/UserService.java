package com.netas.coop.FlexibleHours.services;

import java.util.List;
import java.util.stream.Collectors;

import com.netas.coop.FlexibleHours.repositories.UserRepository;
import com.netas.coop.FlexibleHours.responses.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map((user) -> new UserResponse(user)).collect(Collectors.toList());
    }

    public UserResponse getUserById(long userId) {
        return new UserResponse(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("UserEntity not found with id: " + userId)));
    }
}
