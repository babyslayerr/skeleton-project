package com.example.hanghaeprestudy.comments;

import com.example.hanghaeprestudy.posts.GetPostResponse;
import com.example.hanghaeprestudy.posts.Post;
import com.example.hanghaeprestudy.posts.PostRepository;
import com.example.hanghaeprestudy.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
class CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public void postComment(Long postId, String content, String author) {

        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = new Comment(post,content,author);

        commentRepository.save(comment);

    }
}
