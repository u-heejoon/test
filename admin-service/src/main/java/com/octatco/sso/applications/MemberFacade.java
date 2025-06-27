package com.octatco.sso.applications;

import com.octatco.sso.domains.member.MemberInfo;
import com.octatco.sso.domains.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;

    public MemberInfo.Main retrieveMemberInfo(final Long id) {
        return memberService.retrieveMember(id);
    }

}
