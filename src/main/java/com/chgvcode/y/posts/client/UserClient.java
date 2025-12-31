package com.chgvcode.y.posts.client;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chgvcode.y.posts.client.dto.UserResponse;

@FeignClient(name = "users")
public interface UserClient {
    
    @GetMapping("/api/user")
    List<UserResponse> getUsers(@RequestParam(required = false) List<UUID> uuids);
}
