package com.chgvcode.y.posts.service;

import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.dto.UserMessage;
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
    
}
