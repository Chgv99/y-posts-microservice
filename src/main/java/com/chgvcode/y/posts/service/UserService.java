package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.dto.UserMessage;
import com.chgvcode.y.posts.dto.UserResponse;
import com.chgvcode.y.posts.entity.User;
import com.chgvcode.y.posts.entity.UserEntity;
import com.chgvcode.y.posts.repository.UserRepository;

import jakarta.transaction.Transactional;
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
    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();
        return new User(userEntity.getId(), userEntity.getUuid(), userEntity.getUsername());
    }

    @Override
    public User getUserByUuid(UUID uuid) {
        UserEntity userEntity = userRepository.findByUuid(uuid).orElseThrow();
        return new User(userEntity.getId(), userEntity.getUuid(), userEntity.getUsername());
    }

    @Override
    public List<User> getUsersByUuids(List<UUID> uuids) {
        return userRepository.findByUuidIn(uuids).stream().map(user -> {
            return new User(user.getId(), user.getUuid(), user.getUsername());
        }).toList();
    }

    @Override
    @Transactional
    public void deleteUser(UserMessage userMessage) {
        userRepository.deleteByUsername(userMessage.getUsername());
    }
    
}
