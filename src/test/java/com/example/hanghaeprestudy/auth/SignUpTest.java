package com.example.hanghaeprestudy.auth;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SignUpTest {

    @Autowired
    private AuthService authService;

    @Test
    @Transactional
    void 회원저장테스트(){
        authService.postMember(getAddMemberRequest());
    }

    @Test
    @Transactional
    void 중복회원저장테스트(){

        authService.postMember(getAddMemberRequest());

        Assertions.assertThrows(DupliUsernameException.class,
                () ->
                    authService.postMember(getAddMemberRequest())
                );
    }

    private static AddMemberRequest getAddMemberRequest() {
        String username = "username";
        String password = "password";
        AddMemberRequest addMemberRequest = new AddMemberRequest(username, password);
        return addMemberRequest;
    }

}
