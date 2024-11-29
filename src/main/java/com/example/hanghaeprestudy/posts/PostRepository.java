package com.example.hanghaeprestudy.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
