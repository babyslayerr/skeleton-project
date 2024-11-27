package com.example.hanghaeprestudy.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
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
    void 토큰생성테스트(){

    }

    class TokenUtil {
        static PublicKey publicKey= null;
        static PrivateKey privateKey = null;

        static KeyPairGenerator keyPairGenerator;

        static {
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        static Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);

        static String createToken(){

            keyPairGenerator.initialize(2048);

            KeyPair keyPair = keyPairGenerator.genKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();


            String token = JWT.create()
                    .withClaim("key","value")
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        }

        static void decodeToken(String token){


                DecodedJWT decodedJWT;

                JWTVerifier verifier = JWT.require(algorithm)
                        // specify any specific claim validations
                        .withIssuer("auth0")
                        // reusable verifier instance
                        .build();

                decodedJWT = verifier.verify(token);


                System.out.println(decodedJWT.getClaim("key"));


        }


    }
}
