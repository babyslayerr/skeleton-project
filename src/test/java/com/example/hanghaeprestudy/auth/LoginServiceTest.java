package com.example.hanghaeprestudy.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp(){
        this.authService = new AuthService(new MemberRepository());
    }

    @Test
    void 로그인테스트(){

        // given
        String username = "username";
        String password = "password";
        authService.postMember(username,password);

        // when
        PostLoginResponse postLoginResponse = authService.login(username, password);

        // then
        Assertions.assertNotNull(postLoginResponse);
    }
}
