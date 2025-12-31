package com.chgvcode.y.posts.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chgvcode.y.posts.dto.PostRequest;
import com.chgvcode.y.posts.dto.PostResponse;
import com.chgvcode.y.posts.model.PostEntity;
import com.chgvcode.y.posts.service.PostService;

import lombok.RequiredArgsConstructor;


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
    public ResponseEntity<PostResponse> createPost(@RequestHeader("X-User-Uuid") UUID userUuid, @RequestBody PostRequest request) {
        PostResponse postResponse = postService.createPost(request.message(), userUuid);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
    
}
