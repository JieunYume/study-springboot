package com.nstgic.jwt.repository;

import com.nstgic.jwt.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchingRepository extends JpaRepository<Matching, Long> {

    Optional<Matching> findByMember1AndMember2(Long member1, Long member2);

}
