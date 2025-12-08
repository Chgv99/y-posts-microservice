package com.chgvcode.y.posts.dto;

import java.time.Instant;

public record PostResponse(
    String message,
    Instant createdAt
) {}
