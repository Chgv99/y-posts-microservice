package com.chgvcode.y.posts.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chgvcode.y.posts.dto.CreatePostResponse;
import com.chgvcode.y.posts.dto.GetPostResponse;
import com.chgvcode.y.posts.dto.PostRequest;
import com.chgvcode.y.posts.service.PostService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public Page<GetPostResponse> getPosts(
            // @RequestParam Long authorId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt,desc") String sort
    ) {
        String[] sortParams = sort.split(",");
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0])
        );

        return postService.getPosts(pageable);
    }

    @PostMapping
    public ResponseEntity<CreatePostResponse> createPost(@RequestHeader("X-User-Uuid") UUID userUuid, @RequestBody PostRequest request) {
        CreatePostResponse postResponse = postService.createPost(request.message(), userUuid);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
    
}
