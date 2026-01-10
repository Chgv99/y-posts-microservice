package com.chgvcode.y.posts.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chgvcode.y.posts.dto.CreatePostResponse;
import com.chgvcode.y.posts.dto.GetPostResponse;

public interface IPostService {
    public Page<GetPostResponse> getPostsByUsername(String username, Pageable pageable);
    public Page<GetPostResponse> getPostsByUuid(UUID authorUuid, Pageable pageable);
    public Page<GetPostResponse> getPosts(Pageable pageable);
    public CreatePostResponse createPost(String message, UUID authorUuid);
}
