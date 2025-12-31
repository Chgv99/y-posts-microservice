package com.chgvcode.y.posts.dto;

import java.time.Instant;

import com.chgvcode.y.posts.client.dto.UserResponse;

public record GetPostResponse(
    String message,
    UserResponse author,
    Instant createdAt
) {}
