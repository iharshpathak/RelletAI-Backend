package com.RelletAI.user.controller;

import com.RelletAI.user.entity.User;
import com.RelletAI.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(
            @RequestBody User user) {

        return userService.save(user);
    }
}
