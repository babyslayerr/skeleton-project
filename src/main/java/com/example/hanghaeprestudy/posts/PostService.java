package com.example.hanghaeprestudy.posts;

class PostService {
    private final PostRepository postRepository;

    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(AddPostRequest request) {
        Post post = new Post(request.subject(), request.content(), request.author(), request.createdDate(), request.postPassword());
        postRepository.save(post);
    }
}
