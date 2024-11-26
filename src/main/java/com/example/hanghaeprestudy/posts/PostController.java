package com.example.hanghaeprestudy.posts;

import com.example.hanghaeprestudy.common.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    ResponseEntity<Object> getPostList(){
        Map<String, Object> map = new HashMap();
        List<GetPostResponse> list = postService.getAll();
        map.put("postList",list);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @PostMapping("/api/post")
    ResponseEntity<Message> postPost(@RequestBody AddPostRequest addPostRequest){
        postService.savePost(addPostRequest);
        Message body = new Message();
        body.setSuccess();
        return new ResponseEntity(body,HttpStatus.OK);
    }

    @GetMapping("/api/post/{id}")
    GetPostResponse getPost(@PathVariable("id") Long id){
        return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    PutPostResponse putPost(@PathVariable("id") Long id, @RequestBody PutPostRequest putPostRequest){
        return postService.putPost(id, putPostRequest);
    }

    @DeleteMapping("/api/post/{id}")
    ResponseEntity<Message> deletePost(@PathVariable("id") Long id, @RequestParam("postPassword") String postPassword){
        postService.deletePost(id,postPassword);
        Message message = new Message();
        message.setSuccess();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
