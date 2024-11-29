package com.example.hanghaeprestudy.auth;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenUtil tokenUtil;

    @Test
    @Transactional
    void 로그인테스트(){

        // given
        String username = "username";
        String password = "password";
        ROLE role = ROLE.USER;
        AddMemberRequest addMemberRequest = new AddMemberRequest(username, password, role);
        authService.postMember(addMemberRequest);

        // when
        PostLoginResponse postLoginResponse = authService.login(username, password);

        // then
        Assertions.assertNotNull(postLoginResponse);
    }

    @Test
    void 토큰테스트(){

        String token = tokenUtil.createToken(postLoginResponse);
        tokenUtil.decodeToken(token);

    }

}
