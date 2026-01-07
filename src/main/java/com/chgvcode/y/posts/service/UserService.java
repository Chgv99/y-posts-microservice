package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.dto.UserMessage;
import com.chgvcode.y.posts.dto.UserResponse;
import com.chgvcode.y.posts.entity.UserEntity;
import com.chgvcode.y.posts.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserMessage userMessage) {
        UserEntity userEntity = new UserEntity(userMessage.getUuid(), userMessage.getUsername());
        userRepository.save(userEntity);
    }

    @Override
    public List<UserResponse> getUsersByUuids(List<UUID> uuids) {
        return userRepository.findByUuidIn(uuids).stream().map(user -> {
            return new UserResponse(user.getUuid(), user.getUsername());
        }).toList();
    }
    
}
