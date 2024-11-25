package com.example.hanghaeprestudy.posts;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    @Transactional
    void 전체게시글목록조회(){
        // given
        postService.savePost(getAddPostRequest());
        List<GetPostResponse> posts = postService.getAll();
        assertEquals(1,posts.size());
    }

    @Test
    void 게시글작성(){
        AddPostRequest request = getAddPostRequest();
        postService.savePost(request);
    }

    @Test
    @Transactional
    void 선택한게시글조회(){
        postService.savePost(getAddPostRequest());
        Long postId = 1L;
        GetPostResponse response = postService.getPost(postId);
        assertEquals(1,response.id());
    }

    @Test
    @Transactional
    void 선택한게시글수정(){
        // given
        postService.savePost(getAddPostRequest());

        Long postId = 1L;
        String modifiedSubject = "수정된 제목";
        String modifiedContent = "수정된 내용";
        String modifiedAuthor = "수정된 작성자명";
        String postPassword = "12345";
        PutPostRequest putPostRequest =  new PutPostRequest(modifiedSubject, modifiedContent, modifiedAuthor,postPassword);
        PutPostResponse putPostResponse = postService.putPost(postId, putPostRequest);
        assertEquals(modifiedSubject,putPostResponse.subject());
    }

    @Test
    @Transactional
    void 선택한게시글삭제(){
        // given
        postService.savePost(getAddPostRequest());

        Long postId = 1L;
        String postPassword = "12345";
        postService.deletePost(postId,postPassword);

        assertThrows(NoSuchElementException.class,
                ()->
                postService.getPost(postId));
    }

    private static AddPostRequest getAddPostRequest() {
        String subject = "제목";
        String content = "내용";
        String author = "작성자명";
        String postPassword = "12345";
        return new AddPostRequest(subject, content, author, postPassword);
    }
}
