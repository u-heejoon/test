package com.octatco.sso.domains.member;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberFetcher memberFetcher;

    @Override
    @Cacheable(cacheNames = "member", key = "#id")
    public MemberInfo.Main retrieveMember(final Long id) {
        return MemberInfo.Main.of(memberFetcher.fetchMemberById(id));
    }

    @Override
    public MemberInfo.MemberName retrieveMember(final String username) {
        return MemberInfo.MemberName.of(memberFetcher.fetchMemberByUsername(username));
    }
}
