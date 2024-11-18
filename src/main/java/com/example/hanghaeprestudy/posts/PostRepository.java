package com.example.hanghaeprestudy.posts;

import java.util.HashMap;
import java.util.Map;

class PostRepository {

    private Long id = 0L;
    private Map<Long, Post> persistence = new HashMap<>();

    public void save(Post post) {
        post.assignId(++id);
        persistence.put(post.getId(), post);
    }
}
