package com.RelletAI.user.controller;

import com.RelletAI.user.dto.CreateUserRequest;
import com.RelletAI.user.dto.UserResponse;
import com.RelletAI.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
public UserResponse createUser(
        @Valid @RequestBody CreateUserRequest request) {

    return userService.save(request);
}

    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{clerkId}")
    public UserResponse getUser(
            @PathVariable String clerkId) {

        return userService.getUserByClerkId(clerkId);
    }
}