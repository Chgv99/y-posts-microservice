package com.chgvcode.y.posts.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chgvcode.y.posts.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    public Page<PostEntity> findByAuthorUuid(UUID authorUuid, Pageable pageable);
}
