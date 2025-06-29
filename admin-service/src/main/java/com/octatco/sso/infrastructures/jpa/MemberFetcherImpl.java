package com.octatco.sso.infrastructures.jpa;

import com.octatco.sso.domains.member.Member;
import com.octatco.sso.domains.member.MemberFetcher;
import com.octatco.sso.exceptoin.GlobalException;
import com.octatco.sso.domains.GlobalErrorResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberFetcherImpl implements MemberFetcher {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member fetchMemberById(final Long id) {
        return memberJpaRepository.findById(id)
          .orElseThrow(() -> new GlobalException(GlobalErrorResponseCode.NOT_FOUND));
    }

    @Override
    public Member fetchMemberByUsername(final String username) {
        return memberJpaRepository.findByUsername(username)
          .orElseThrow();
    }
}
