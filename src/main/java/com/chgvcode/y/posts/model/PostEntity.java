package com.chgvcode.y.posts.model;

import java.time.Instant;
// import java.util.UUID;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // private UUID uuid;
    
    private String message;

    private UUID authorUuid;

    @Column(name = "created_at")
    private Instant createdAt;

    public PostEntity(String message, UUID authorUuid) {
        // this.uuid = new UUID();
        this.message = message;
        this.authorUuid = authorUuid;
        this.createdAt = Instant.now();
    }
}
