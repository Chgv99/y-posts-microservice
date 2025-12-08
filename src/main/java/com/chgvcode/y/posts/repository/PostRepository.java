package com.chgvcode.y.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chgvcode.y.posts.model.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    
}
