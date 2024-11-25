package com.example.hanghaeprestudy.posts;

import org.springframework.util.Assert;

record PutPostRequest(String subject, String content, String author,String postPassword) {
    public PutPostRequest {
        Assert.hasText(subject, "수정된 제목은 필수입니다.");
        Assert.hasText(content, "수정된 내용은 필수입니다.");
        Assert.hasText(author, "수정된 작성자는 필수입니다.");
    }
}
