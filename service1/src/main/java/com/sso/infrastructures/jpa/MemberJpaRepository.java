package com.sso.infrastructures.jpa;

import com.sso.domains.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(final Long id);
    Optional<Member> findByUsername(final String username);

}
