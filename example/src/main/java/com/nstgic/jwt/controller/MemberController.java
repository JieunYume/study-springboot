package com.nstgic.jwt.controller;

import com.nstgic.jwt.dto.Member.MemberResponseDto;
import com.nstgic.jwt.entity.Member;
import com.nstgic.jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MemberController {
    private final MemberService memberService;


//    @GetMapping("/")
//    public ResponseEntity<MemberResponseDto> findMemberInfoById() {
//        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
//    }


    @GetMapping("/info")
    public ResponseEntity<MemberResponseDto> getMemberInfoByUsername(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(memberService.findMemberInfoByUsername(username));
    }

    @GetMapping("/nickname")
    public String getUsernickname(Principal principal){
        Member member = (Member) ((Authentication) principal).getPrincipal();
        return  member.getNickname();
    }





}
