package com.nstgic.jwt.service;

import com.nstgic.jwt.dto.Member.MemberResponseDto;
import com.nstgic.jwt.entity.Member;
import com.nstgic.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
//조회 쿼리만 사용할 예정
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomUserDetailsService customUserDetailsService;


    public Member findMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }


    public MemberResponseDto findMemberInfoByUsername(String username) {
        return customUserDetailsService.findMemberInfoByUsername(username);
    }



    public String findUsernameForFindingId(String nickname, Integer findQuesNum, String findAnswer) {
        Optional<Member> member = memberRepository.findByNicknameAndFindQuesNumAndFindAnswer(nickname, findQuesNum, findAnswer);
        return member.map(Member::getUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with given parameters"));
    }


    public Integer findMemberStateByUsername(String username) {
        MemberResponseDto member = customUserDetailsService.findMemberInfoByUsername(username);

        return member.getState();

    }

    public boolean checkNickname(String nickname) {
        return memberRepository.findByNickname(nickname).isEmpty();
    }
}
