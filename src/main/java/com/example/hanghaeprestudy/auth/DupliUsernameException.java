package com.example.hanghaeprestudy.auth;

class DupliUsernameException extends RuntimeException {
    public DupliUsernameException() {
        super("중복된 username 입니다.");
    }
}
