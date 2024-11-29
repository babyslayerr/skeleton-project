package com.example.hanghaeprestudy.auth;

import org.springframework.stereotype.Component;

@Component
class AuthService {

    private MemberRepository memberRepository;

    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public PostLoginResponse login(String username, String password) {
        Member member = memberRepository.findByUsernameAndPassword(username,password);
        return member!=null?new PostLoginResponse(member.getUsername(),member.getPassword()):null;
    }

    public void postMember(AddMemberRequest addMemberRequest) {
        Member member = new Member(addMemberRequest.username(), addMemberRequest.password(),addMemberRequest.role());
        if (memberRepository.findByUsername(addMemberRequest.username()) != null) {
            throw new DupliUsernameException();
        }
        memberRepository.save(member);
    }
}
