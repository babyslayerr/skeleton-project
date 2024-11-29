package com.example.hanghaeprestudy.comments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;


public class CommentServiceTest {

    private CommentService commentService;


    @BeforeEach
    void setup(){

        commentService = new CommentService(new CommentRepository());
    }

    @Test
    void 댓글저장테스트(){
        Long postId = 1L;
        String content = "댓글 내용";
        String author = "작성자";
        commentService.postComment(postId, content, author);
    }


    private class CommentService {

        private CommentRepository commentRepository;

        public CommentService(CommentRepository commentRepository) {
            this.commentRepository = commentRepository;
        }

        public void postComment(Long postId, String content, String author) {

            Comment comment = new Comment(postId,content,author);

            commentRepository.save(comment);

        }
    }

    private class Comment {

        private Long id;
        private final Long postId;
        private final String content;
        private final String author;


        public Comment(Long postId, String content, String author) {
            Assert.notNull(postId, "게시글 ID는 필수입니다.");
            Assert.hasText(content, "게시글 내용은 필수입니다.");
            Assert.hasText(author, "작성자는 필수 입니다.");
            this.postId = postId;
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

    private class CommentRepository {
        private Long sequence = 0L;
        Map<Long, Comment> map = new HashMap<>();

        public void save(Comment comment) {
            comment.assignId(++sequence);
            map.put(comment.getId(), comment);
        }
    }
}
