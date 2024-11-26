package com.example.hanghaeprestudy.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 지연로딩 proxy 객체 생성을 위함
@Getter
class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void assignId(Long id) {
        this.id = id;
    }

}
