package com.example.hanghaeprestudy.posts;

import org.springframework.util.Assert;

import java.time.LocalDate;

record AddPostRequest(String subject, String content, String author,  String postPassword) {
    public AddPostRequest {
        Assert.hasText(subject, "제목이 있어야 합니다.");
        Assert.hasText(content, "내용이 있어야 합니다.");
        Assert.hasText(author, "작성자가 있어야 합니다.");
        Assert.hasText(postPassword, "게시글 비밀번호가 있어야 합니다.");
    }
}
