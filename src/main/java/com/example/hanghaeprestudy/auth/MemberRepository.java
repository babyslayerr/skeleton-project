package com.example.hanghaeprestudy.auth;

import java.util.HashMap;
import java.util.Map;

class MemberRepository {
    private Long id = 0L;
    private Map<Long, Member> map = new HashMap<>();

    public void save(Member member) {
        member.assignId(id);
        map.put(member.getId(), member);

    }

    public Member findByUsername(String username) {
        for (Member member : map.values()) {
            if (member.getUsername().equals(username)) return member;
        }
        return null;
    }

    public Member findByUsernameAndPassword(String username, String password) {
        for (Member member : map.values()) {
            if (member.getUsername().equals(username) && member.getPassword().equals(password)) return member;
        }
        return null;
    }
}
