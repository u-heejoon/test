package com.octatco.sso.infrastructures.querydsl;

import com.octatco.sso.domains.member.Member;
import com.octatco.sso.domains.member.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberQueryDslRepositoryImpl implements MemberQueryDslRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<Member> findByMemberId(final Long memberId) {
        QMember member = QMember.member;
        return Optional.ofNullable(query.selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne());
    }
}
