package com.chgvcode.y.posts.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chgvcode.y.posts.client.UserClient;
import com.chgvcode.y.posts.client.dto.UserResponse;
import com.chgvcode.y.posts.dto.CreatePostResponse;
import com.chgvcode.y.posts.dto.GetPostResponse;
import com.chgvcode.y.posts.model.PostEntity;
import com.chgvcode.y.posts.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;

    private final UserClient userClient;

    public Page<GetPostResponse> getPosts(Pageable pageable) {
        Page<PostEntity> page = postRepository.findAll(pageable);

        List<UUID> userUuids = page.getContent().stream().map(PostEntity::getAuthorUuid).collect(Collectors.toList());
        List<UserResponse> userResponses = userClient.getUsers(userUuids);
        Map<UUID, UserResponse> userMap = userResponses.stream()
                .collect(Collectors.toMap(u -> u.uuid(), u -> u));
        List<GetPostResponse> dtos = page.getContent().stream().map(
                post -> new GetPostResponse(post.getMessage(), userMap.get(post.getAuthorUuid()), post.getCreatedAt()))
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
