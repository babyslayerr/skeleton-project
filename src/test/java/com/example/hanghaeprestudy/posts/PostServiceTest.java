package com.example.hanghaeprestudy.posts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PostServiceTest {

    private PostService postService;
    private PostRepository postRepository;

    @BeforeEach
    void setup(){
        postRepository = new PostRepository();
        postService = new PostService(postRepository);
    }

    @Test
    void 게시글작성(){

        AddPostRequest request = getAddPostRequest();
        postService.save(request);
    }

    private static AddPostRequest getAddPostRequest() {
        String subject = "제목";
        String content = "내용";
        String author = "작성자명";
        LocalDate createdDate = LocalDate.now();
        String postPassword = "12345";
        return new AddPostRequest(subject, content, author, createdDate, postPassword);
    }


}
