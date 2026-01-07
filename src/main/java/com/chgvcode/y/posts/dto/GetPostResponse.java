package com.chgvcode.y.posts.dto;

import java.time.Instant;

public record GetPostResponse(
    String message,
    UserResponse author,
    Instant createdAt
) {}
