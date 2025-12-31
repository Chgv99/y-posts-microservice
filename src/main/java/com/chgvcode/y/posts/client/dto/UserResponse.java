package com.chgvcode.y.posts.client.dto;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(
    Long id,
    UUID uuid,
    String username,
    Instant createdAt
) {}
