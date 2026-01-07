package com.chgvcode.y.posts.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chgvcode.y.posts.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {    
    public List<UserEntity> findByUuidIn(List<UUID> uuids);
}
