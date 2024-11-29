package com.example.hanghaeprestudy.auth;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

record AddMemberRequest(String username, String password,ROLE role) {
    AddMemberRequest {
        // username 이 정규표현식이랑 동일한지 확인
        Assert.hasText(username, "username must not be empty");
        String usernameRegex = "^[a-z0-9]{4,10}$";
        Assert.isTrue(Pattern.matches(usernameRegex, username), "사용할 수 없는 username 패턴입니다.");

        Assert.hasText(password, "password must not be empty");
        String passwordRegex = "^[a-zA-Z0-9]{4,15}$";
        Assert.isTrue(Pattern.matches(passwordRegex, password), "사용할 수 없는 username 패턴입니다.");
    }
}
