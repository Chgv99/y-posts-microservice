package com.chgvcode.y.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chgvcode.y.posts.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
