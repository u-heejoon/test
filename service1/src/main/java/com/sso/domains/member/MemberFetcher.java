package com.sso.domains.member;

public interface MemberFetcher {

    Member fetchMemberById(Long id);
    Member fetchMemberByUsername(String username);

}
