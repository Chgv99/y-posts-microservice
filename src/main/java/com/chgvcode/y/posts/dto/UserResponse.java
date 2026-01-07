package com.chgvcode.y.posts.dto;

import java.util.UUID;

public record UserResponse(
    UUID uuid,
    String username
) {}
