package com.example.hanghaeprestudy.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CommentRepository extends JpaRepository<Comment, Long> {



//    private Long sequence = 0L;
//    Map<Long, Comment> map = new HashMap<>();
//
//    public void save(Comment comment) {
//        comment.assignId(++sequence);
//        map.put(comment.getId(), comment);
//    }
}
