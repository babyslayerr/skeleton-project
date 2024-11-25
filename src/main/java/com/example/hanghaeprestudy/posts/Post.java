package com.example.hanghaeprestudy.posts;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String content;
    private String author;
    @CreatedDate
    private LocalDate createdDate;
    private String postPassword;

    public Post(String subject, String content, String author, String postPassword) {
        Assert.hasText(subject, "제목이 있어야 합니다.");
        Assert.hasText(content, "내용이 있어야 합니다.");
        Assert.hasText(author, "작성자가 있어야 합니다.");
        Assert.hasText(postPassword, "게시글 비밀번호가 있어야 합니다.");
        this.subject = subject;
        this.content = content;
        this.author = author;
        this.postPassword = postPassword;
    }

    public void putPost(PutPostRequest putPostRequest) {
        this.subject = putPostRequest.subject();
        this.content = putPostRequest.content();
        this.author = putPostRequest.author();
    }
}
