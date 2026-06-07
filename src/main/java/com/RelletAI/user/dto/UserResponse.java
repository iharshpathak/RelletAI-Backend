package com.RelletAI.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String clerkId;
    private String name;
    private String email;
    private String imageUrl;
    private Boolean subscription;
}