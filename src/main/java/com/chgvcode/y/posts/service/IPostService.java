package com.chgvcode.y.posts.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chgvcode.y.posts.dto.CreatePostResponse;
import com.chgvcode.y.posts.entity.Post;

public interface IPostService {
    public Page<Post> getPostsByUsername(String username, Pageable pageable);
    public Page<Post> getPostsByUuid(UUID authorUuid, Pageable pageable);
    public Page<Post> getPosts(Pageable pageable);
    public CreatePostResponse createPost(String message, UUID authorUuid);
}
