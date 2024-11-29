package com.example.hanghaeprestudy.auth;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 지연로딩 proxy 객체 생성을 위함(기본 생성자를 사용해 프록시 객체 생성) private 면 접근 불가
@Getter
class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private ROLE role;

    public Member(String username, String password, ROLE role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void assignId(Long id) {
        this.id = id;
    }

}
