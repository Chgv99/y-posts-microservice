package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;

import com.chgvcode.y.posts.dto.UserMessage;
import com.chgvcode.y.posts.entity.User;

public interface IUserService {
    public void createUser(UserMessage userMessage);
    public User getUserByUsername(String username);
    public User getUserByUuid(UUID uuids);
    public List<User> getUsersByUuids(List<UUID> uuids);
    public void deleteUser(UserMessage userMessage);
}
