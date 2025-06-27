package com.octatco.sso.infrastructures.jpa;

import com.octatco.sso.domains.member.Member;
import com.octatco.sso.infrastructures.querydsl.MemberQueryDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberQueryDslRepository {

//    Optional<Member> findById(final Long id);
    Optional<Member> findByUsername(final String username);

}
