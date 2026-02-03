package com.chgvcode.y.posts.entity;

import java.time.Instant;
import java.util.UUID;

public record Post(
    Long id,
    String message,
    UUID authorUuid,
    Instant createdAt
) {}
