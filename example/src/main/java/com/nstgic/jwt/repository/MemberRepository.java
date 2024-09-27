package com.nstgic.jwt.repository;

import com.nstgic.jwt.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Member> findByNicknameAndFindQuesNumAndFindAnswer(String nickname, Integer findQuesNum, String findAnswer);

    Optional<Member> findByNickname(String nickname);
}
