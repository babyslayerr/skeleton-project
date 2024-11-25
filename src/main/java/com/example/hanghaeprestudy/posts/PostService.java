package com.example.hanghaeprestudy.posts;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class PostService {
    private final PostRepository postRepository;

    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void savePost(AddPostRequest request) {
        Post post = new Post(request.subject(), request.content(), request.author(), request.postPassword());
        postRepository.save(post);

    }

    public GetPostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();

        return new GetPostResponse(
                 post.getId()
                ,post.getSubject()
                ,post.getContent()
                ,post.getAuthor()
                ,post.getCreatedDate()
        );
    }

    @Transactional
    public PutPostResponse putPost(Long postId, PutPostRequest putPostRequest) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Post post = optionalPost.orElseThrow();
        if(!post.getPostPassword().equals(putPostRequest.postPassword())){
            throw new RuntimeException("Wrong Password");
        }
        post.putPost(putPostRequest);
        return PutPostResponse.of(post);
    }

    @Transactional
    public void deletePost(Long postId, String postPassword) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Post post = optionalPost.orElseThrow();
        if(post.getPostPassword().equals(postPassword)){
            postRepository.delete(post);
        } else{
            throw new RuntimeException("Wrong Password");
        }
    }

    public List<GetPostResponse> getAll() {
        List<GetPostResponse> postResponseList = postRepository
                .findAll(Sort.by(Sort.Order.desc("createdDate")))
                .stream()
                .map((post) ->
                    GetPostResponse.of(post)
                ).toList();
        return postResponseList;
    }
}
