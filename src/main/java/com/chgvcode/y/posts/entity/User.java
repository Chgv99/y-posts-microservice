package com.chgvcode.y.posts.entity;

import java.util.UUID;

public record User(
    Long id,
    UUID uuid,
    String username
) {}
