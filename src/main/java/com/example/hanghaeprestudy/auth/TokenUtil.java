package com.example.hanghaeprestudy.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


@Component
public class TokenUtil {

    TokenUtil(){

        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.genKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
    }

    private PublicKey publicKey;
    private PrivateKey privateKey;

    private KeyPairGenerator keyPairGenerator;

    private Algorithm algorithm;

    String createToken() {

        String token = JWT.create()
                .withIssuer("hanghae")
                .sign(algorithm);
        return token;
    }

    DecodedJWT decodeToken(String token) {


        DecodedJWT decodedJWT;

        JWTVerifier verifier = JWT.require(algorithm)
                // specify any specific claim validations
                .withIssuer("hanghae")
                // reusable verifier instance
                .build();

        decodedJWT = verifier.verify(token);

        return decodedJWT;


    }


}
// key 문자열로 지정하고싶으면
//String algorithm = "RSA" // for example
//KeyFactory kf = KeyFactory.getInstance(algorithm);
//String publicKeyStr = "-----BEGIN PUBLIC KEY-----f24Defosfvak-----END PUBLIC KEY-----"
//EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyStr.getBytes());
//RSAPublicKey publicKey = kf.generatePublic(keySpec);

