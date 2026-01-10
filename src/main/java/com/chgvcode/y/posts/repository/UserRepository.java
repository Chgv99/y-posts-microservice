package com.chgvcode.y.posts.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chgvcode.y.posts.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {    
    public Optional<UserEntity> findByUsername(String username);
    public Optional<UserEntity> findByUuid(UUID uuid);
    public List<UserEntity> findByUuidIn(List<UUID> uuids);
    public void deleteByUsername(String username);
}
