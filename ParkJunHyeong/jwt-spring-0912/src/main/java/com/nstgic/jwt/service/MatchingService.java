package com.nstgic.jwt.service;


import com.nstgic.jwt.entity.Matching;
import com.nstgic.jwt.entity.Member;
import com.nstgic.jwt.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchingService {

    private final MatchingRepository matchingRepository;
    public void createMatching(Member member1, Member member2) throws Exception{

        Optional<Matching> matching1 = matchingRepository.findByMember1AndMember2(member1.getId(), member2.getId());
        Optional<Matching> matching2 = matchingRepository.findByMember1AndMember2(member2.getId(), member1.getId());

        if(matching1.isPresent() || matching2.isPresent()) {
            throw new Exception("이미 존재하는 매칭입니다.");
        }

        Matching matching =  Matching.builder()
                .member1(member1.getId())
                .member2(member2.getId())
                .build();
        matchingRepository.save(matching);
        member1.getMatching().getMatchingList().add(member2);
        member2.getMatching().getMatchingList().add(member1);
    }
}