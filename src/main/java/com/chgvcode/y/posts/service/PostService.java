package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.model.PostEntity;
import com.chgvcode.y.posts.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    // Needs to map postentity into postresponse
    public List<PostEntity> getPosts() {
        return postRepository.findAll();
    }

    public PostEntity createPost(String message, UUID authorUuid) {
        PostEntity post = new PostEntity(message, authorUuid);
        return postRepository.save(post);
    }
}
