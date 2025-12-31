package com.chgvcode.y.posts.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.dto.PostResponse;
import com.chgvcode.y.posts.model.PostEntity;
import com.chgvcode.y.posts.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    public Page<PostEntity> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public PostResponse createPost(String message, UUID authorUuid) {
        PostEntity post = new PostEntity(message, authorUuid);
        PostEntity savedPost = postRepository.save(post);
        return new PostResponse(savedPost.getMessage(), savedPost.getAuthorUuid().toString(), savedPost.getCreatedAt());
    }
}
