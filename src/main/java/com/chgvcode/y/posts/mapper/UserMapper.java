package com.chgvcode.y.posts.mapper;

import org.mapstruct.Mapper;

import com.chgvcode.y.posts.dto.UserResponse;
import com.chgvcode.y.posts.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserResponse toResponse(User user);
}
