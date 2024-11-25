package com.example.hanghaeprestudy.auth;

class AuthService {

    private MemberRepository memberRepository;

    public AuthService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void postMember(String username, String password) {
        Member member = new Member(username, password);
        if (memberRepository.findByUsername(username) != null) {
            throw new DupliUsernameException();
        }
        memberRepository.save(member);
    }
}
