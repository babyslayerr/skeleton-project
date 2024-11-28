package com.example.hanghaeprestudy.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;

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
        AddMemberRequest addMemberRequest = new AddMemberRequest(username, password);
        authService.postMember(addMemberRequest);

        // when
        PostLoginResponse postLoginResponse = authService.login(username, password);

        // then
        Assertions.assertNotNull(postLoginResponse);
    }

    @Test
    void 토큰테스트(){

        String token = tokenUtil.createToken();
        tokenUtil.decodeToken(token);

    }

}
