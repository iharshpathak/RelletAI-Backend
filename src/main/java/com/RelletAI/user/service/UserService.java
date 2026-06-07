package com.RelletAI.user.service;

import com.RelletAI.user.dto.CreateUserRequest;
import com.RelletAI.user.dto.UserResponse;
import com.RelletAI.user.entity.User;
import com.RelletAI.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.RelletAI.user.exception.UserNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse save(CreateUserRequest request) {

        User user = User.builder()
                .clerkId(request.getClerkId())
                .name(request.getName())
                .email(request.getEmail())
                .imageUrl(request.getImageUrl())
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

   public UserResponse getUserByClerkId(String clerkId) {

    User user = userRepository.findByClerkId(clerkId)
            .orElseThrow(() ->
                    new UserNotFoundException("User not found with clerkId: " + clerkId));

    return mapToResponse(user);
}

    private UserResponse mapToResponse(User user) { //mapper method so that evrytime builder na likhna pade

        return UserResponse.builder()
                .id(user.getId())
                .clerkId(user.getClerkId())
                .name(user.getName())
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .subscription(user.getSubscription())
                .build();
    }
}