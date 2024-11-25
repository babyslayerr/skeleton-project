package com.example.hanghaeprestudy.posts;

import org.springframework.util.Assert;

import java.time.LocalDate;

record GetPostResponse(Long id, String subject, String content, String author, LocalDate createdDate) {
    public GetPostResponse {
        Assert.notNull(id,"해당 게시글 식별자가 있어야 합니다.");
        Assert.hasText(subject,"게시글 명이 있어야 합니다.");

    }

    public static GetPostResponse of(Post post) {
        return new GetPostResponse(post.getId(), post.getSubject(),post.getContent(), post.getAuthor(), post.getCreatedDate());
    }
}
