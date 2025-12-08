package com.chgvcode.y.posts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chgvcode.y.posts.dto.PostRequest;
import com.chgvcode.y.posts.dto.PostResponse;
import com.chgvcode.y.posts.model.PostEntity;
import com.chgvcode.y.posts.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    
    // Needs mapping
    @GetMapping
    public ResponseEntity<List<PostEntity>> getPosts() {
        List<PostEntity> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        PostEntity postEntity = postService.createPost(request.message());
        PostResponse postResponse = new PostResponse(postEntity.getMessage(), postEntity.getCreatedAt());
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
    
}
