package com.example.hanghaeprestudy.posts;

import org.springframework.util.Assert;

import java.time.LocalDate;

class Post {
    private Long id;
    private final String subject;
    private final String content;
    private final String author;
    private final LocalDate createdDate;
    private final String postPassword;

    public Post(String subject, String content, String author, LocalDate createdDate, String postPassword) {
        Assert.hasText(subject, "제목이 있어야 합니다.");
        Assert.hasText(content, "내용이 있어야 합니다.");
        Assert.hasText(author, "작성자가 있어야 합니다.");
        Assert.notNull(createdDate, "작성일자가 있어야 합니다.");
        Assert.hasText(postPassword, "게시글 비밀번호가 있어야 합니다.");
        this.subject = subject;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.postPassword = postPassword;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
