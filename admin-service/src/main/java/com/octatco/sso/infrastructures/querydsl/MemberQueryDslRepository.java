package com.octatco.sso.infrastructures.querydsl;

import com.octatco.sso.domains.member.Member;

import java.util.Optional;

public interface MemberQueryDslRepository {
    Optional<Member> findByMemberId(final Long memberId);
}
