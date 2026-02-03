package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.dto.CreatePostResponse;
import com.chgvcode.y.posts.entity.Post;
import com.chgvcode.y.posts.entity.PostEntity;
import com.chgvcode.y.posts.entity.User;
import com.chgvcode.y.posts.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    private final IUserService userService;

    public Page<Post> getPostsByUsername(String username, Pageable pageable) {
        User user = userService.getUserByUsername(username);

        Page<PostEntity> page = postRepository.findByAuthorUuid(user.uuid(), pageable);

        List<Post> dtos = page.getContent().stream().map(
                postEntity -> new Post(postEntity.getId(), postEntity.getMessage(), user.uuid(), postEntity.getCreatedAt()))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    public Page<Post> getPostsByUuid(UUID authorUuid, Pageable pageable) {
        Page<PostEntity> page = postRepository.findByAuthorUuid(authorUuid, pageable);

        User user = userService.getUserByUuid(authorUuid);

        List<Post> dtos = page.getContent().stream().map(
                postEntity -> new Post(postEntity.getId(), postEntity.getMessage(), user.uuid(), postEntity.getCreatedAt()))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    public Page<Post> getPosts(Pageable pageable) {
        Page<PostEntity> page = postRepository.findAll(pageable);

        // Set<UUID> userUuids = page.getContent().stream().map(PostEntity::getAuthorUuid).collect(Collectors.toSet());
        // List<User> users = userService.getUsersByUuids(List.copyOf(userUuids)); // userClient.getUsers(List.copyOf(userUuids));

        // Map<UUID, User> userMap = users.stream()
        //         .collect(Collectors.toMap(user -> user.uuid(), user -> user));
        List<Post> dtos = page.getContent().stream().map(
                postEntity -> new Post(postEntity.getId(), postEntity.getMessage(), postEntity.getAuthorUuid(), postEntity.getCreatedAt()))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    public CreatePostResponse createPost(String message, UUID authorUuid) {
        PostEntity post = new PostEntity(message, authorUuid);
        PostEntity savedPost = postRepository.save(post);
        return new CreatePostResponse(savedPost.getMessage(), savedPost.getAuthorUuid().toString(),
                savedPost.getCreatedAt());
    }
}
