package com.chgvcode.y.posts.dto;

import java.time.Instant;

public record CreatePostResponse(
    String message,
    String author,
    Instant createdAt
) {}
