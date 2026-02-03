package com.chgvcode.y.posts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chgvcode.y.posts.dto.GetPostResponse;
import com.chgvcode.y.posts.entity.Post;
import com.chgvcode.y.posts.entity.User;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface PostMapper {

    @Mapping(target = "author", source = "user")
    GetPostResponse toGetPostResponse(Post post, User user);
}
