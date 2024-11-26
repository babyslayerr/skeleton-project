package com.example.hanghaeprestudy.auth;

import com.example.hanghaeprestudy.common.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/auth/signup")
    ResponseEntity postSignUpMember(@RequestBody AddMemberRequest addMemberRequest){

        authService.postMember(addMemberRequest);

        Message message = new Message();
        message.setSuccess();
        return new ResponseEntity(message, HttpStatus.OK);

    }

    @PostMapping("/api/auth/login")
    ResponseEntity postLogin(@RequestBody Map<String,String> request){
        PostLoginResponse postLoginResponse = authService.login(request.get("username"), request.get("password"));
        Message message = new Message();
        message.setSuccess();
        message.setData(postLoginResponse);
        return new ResponseEntity(message,HttpStatus.OK);
    }

}
