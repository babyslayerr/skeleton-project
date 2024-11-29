package com.example.hanghaeprestudy.comments;

import com.example.hanghaeprestudy.posts.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    private String content;
    private String author;


    public Comment(Post post, String content, String author) {
        Assert.notNull(post, "게시글 필수입니다.");
        Assert.hasText(content, "댓글 내용은 필수입니다.");
        Assert.hasText(author, "작성자는 필수 입니다.");
        this.post = post;
        this.content = content;
        this.author = author;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
