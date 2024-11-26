package com.example.hanghaeprestudy.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

    Member findByUsernameAndPassword(String username, String password);
//    private Long id = 0L;
//    private Map<Long, Member> map = new HashMap<>();
//
////    public void save(Member member) {
////        member.assignId(id);
////        map.put(member.getId(), member);
////
////    }
////
////    public Member findByUsername(String username) {
////        for (Member member : map.values()) {
////            if (member.getUsername().equals(username)) return member;
////        }
////        return null;
////    }
////
////    public Member findByUsernameAndPassword(String username, String password) {
////        for (Member member : map.values()) {
////            if (member.getUsername().equals(username) && member.getPassword().equals(password)) return member;
////        }
////        return null;
////    }
}
