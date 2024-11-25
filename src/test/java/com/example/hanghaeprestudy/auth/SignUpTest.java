package com.example.hanghaeprestudy.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignUpTest {

    private AuthService authService;
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp(){
        this.memberRepository = new MemberRepository();
        this.authService = new AuthService(memberRepository);
    }

    @Test
    void 회원저장테스트(){

        String username = "username";
        String password = "password";
        new AddMemberRequest(username,password);
        authService.postMember(username, password);
    }

    @Test
    void 중복회원저장테스트(){

        String username = "username";
        String password = "password";
        authService.postMember(username, password);

        Assertions.assertThrows(DupliUsernameException.class,
                () ->
                    authService.postMember(username, password)
                );
    }

}
