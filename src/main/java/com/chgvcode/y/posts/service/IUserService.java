package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;

import com.chgvcode.y.posts.dto.UserMessage;
import com.chgvcode.y.posts.dto.UserResponse;

public interface IUserService {
    public void createUser(UserMessage userMessage);
    public UserResponse getUserByUsername(String username);
    public UserResponse getUserByUuid(UUID uuids);
    public List<UserResponse> getUsersByUuids(List<UUID> uuids);
}
