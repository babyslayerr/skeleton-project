package com.example.hanghaeprestudy.comments;

import com.example.hanghaeprestudy.posts.AddPostRequest;
import com.example.hanghaeprestudy.posts.Post;
import com.example.hanghaeprestudy.posts.PostService;
import com.example.hanghaeprestudy.posts.PostServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;


    @Test
    void 댓글저장테스트(){

        // given
        // 부모 게시글 저장
        postService.savePost(getAddPostRequest());
        // postId는 위에서 받아와야함 refactoring 예정
        Long postId = 1L;
        String content = "댓글 내용";
        String author = "작성자";
        commentService.postComment(postId, content, author);
    }

    private static AddPostRequest getAddPostRequest() {
        String subject = "제목";
        String content = "내용";
        String author = "작성자명";
        String postPassword = "12345";
        return new AddPostRequest(subject, content, author, postPassword);
    }


}
