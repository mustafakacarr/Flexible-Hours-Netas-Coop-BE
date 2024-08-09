package com.netas.coop.FlexibleHours.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.netas.coop.FlexibleHours.configuration.PasswordEncoderConfig;
import com.netas.coop.FlexibleHours.repositories.UserRepository;
import com.netas.coop.FlexibleHours.entities.UserEntity;
import com.netas.coop.FlexibleHours.enums.Role;
import com.netas.coop.FlexibleHours.requests.*;
import com.netas.coop.FlexibleHours.responses.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoderConfig passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoderConfig passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map((user) -> new UserResponse(user)).collect(Collectors.toList());
    }

    public UserResponse getUserById(long userId) {
        return new UserResponse(userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("UserEntity not found with id: " + userId)));
    }

    public UserResponse getUserByUsername(String username) {
        return new UserResponse(userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("UserEntity not found with username: " + username)));
    }

    public UserResponse createUser(CreateUserByAdminRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(request.fullName());
        userEntity.setEmail(request.email());
        userEntity.setPassword(passwordEncoder.getEncoder().encode(request.password()));
        userEntity.setRegistrationNumber(request.registrationNumber());
        userEntity.setDepartmentEntity(request.departmentEntity());
        userEntity.setUnitEntity(request.unitEntity());
        
        Set<Role> roles = new HashSet<>(request.roles());
        userEntity.setAuthorities(roles);
        
        userRepository.save(userEntity);
        return new UserResponse(userEntity);
    }
    

    public UserResponse updateUser(long userId, UpdateUserRequest userRequest) {
        UserEntity existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        existingUser.setFullName(userRequest.fullName());

        existingUser.setEmail(userRequest.email());

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRequest.role());

        return new UserResponse(userRepository.save(existingUser));
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    public UserResponse changePassword(long userId, ChangePasswordRequest request) {
        UserEntity userEntity = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("UserEntity not found with id: " + userId));
        if (!passwordEncoder.getEncoder().matches(request.oldPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Old password is incorrect.");
        }
        userEntity.setPassword(passwordEncoder.getEncoder().encode(request.newPassword()));
        return new UserResponse(userRepository.save(userEntity));
    }
}
