package com.chgvcode.y.posts.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.chgvcode.y.posts.dto.UserMessage;
import com.chgvcode.y.posts.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserMessageConsumer {
    private final IUserService userService;

    @RabbitListener(queues = "userCreationQueue")
    public void consumeUserCreated(UserMessage userMessage) {
        userService.createUser(userMessage);
    }

    @RabbitListener(queues = "userDeletionQueue")
    public void consumeUserDeleted(UserMessage userMessage) {
        userService.deleteUser(userMessage);
    }

}
