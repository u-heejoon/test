package com.octatco.sso.domains.member;

public interface MemberService {
    MemberInfo.Main retrieveMember(final Long id);

    MemberInfo.MemberName retrieveMember(final String username);
}
