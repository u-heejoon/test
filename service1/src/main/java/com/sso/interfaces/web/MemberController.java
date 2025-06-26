package com.sso.interfaces.web;

import com.sso.applications.MemberFacade;
import com.sso.domains.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;

    @GetMapping("/member/{id}")
    public MemberDto.MemberResponse retrieveMember(@PathVariable("id") final Long id) {
        return MemberDto.MemberResponse.from(memberFacade.retrieveMemberInfo(id));
    }
}
