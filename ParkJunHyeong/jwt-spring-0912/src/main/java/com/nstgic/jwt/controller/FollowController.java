package com.nstgic.jwt.controller;


import com.nstgic.jwt.dto.followDto.FollowAddResponseDto;
import com.nstgic.jwt.dto.followDto.FollowListResponseDto;
import com.nstgic.jwt.entity.Member;
import com.nstgic.jwt.repository.MemberRepository;
import com.nstgic.jwt.service.FollowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowingService followingService;
    private final MemberRepository memberRepository;

    @PostMapping("/{followedId}")
    public ResponseEntity<FollowAddResponseDto> addFollow (@PathVariable Long followedId, Principal principal) throws Exception {
        Optional<Member> follwedMember = memberRepository.findById(followedId);
        String follwedUsername = follwedMember.get().getUsername();
        return ResponseEntity.ok(followingService.addFollow(follwedUsername, principal.getName()));
    }

    @GetMapping("/followingList")
    public ResponseEntity<FollowListResponseDto> findFollowing(Principal principal) {
        Optional<Member> member = memberRepository.findByUsername(principal.getName());
        return ResponseEntity.ok(followingService.findFollowing(member.get()));
    }
}
