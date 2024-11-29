package com.example.hanghaeprestudy.auth;

import com.example.hanghaeprestudy.common.Message;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping("/api/auth/signup")
    ResponseEntity postSignUpMember(@RequestBody AddMemberRequest addMemberRequest){

        try{
            authService.postMember(addMemberRequest);
        } catch (DupliUsernameException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }

        Message message = new Message();
        message.setSuccess();
        return new ResponseEntity(message, HttpStatus.OK);

    }

    @PostMapping("/api/auth/login")
    ResponseEntity postLogin(@RequestBody Map<String,String> request,HttpServletResponse response){
        PostLoginResponse postLoginResponse = authService.login(request.get("username"), request.get("password"));
        // 실패 상황
        if(postLoginResponse==null){
            return ResponseEntity.status(401).body("invalid credentials");
        }
        Message message = new Message();
        message.setSuccess();
        message.setData(postLoginResponse);

        String token = tokenUtil.createToken(postLoginResponse);
        Cookie authorizationCookie = new Cookie("Authorization", token);
        response.addCookie(authorizationCookie);
        return new ResponseEntity(message,HttpStatus.OK);
    }

}
