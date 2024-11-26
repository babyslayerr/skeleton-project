package com.example.hanghaeprestudy.auth;

class Member {
    private String username;
    private String password;
    private Long id;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
