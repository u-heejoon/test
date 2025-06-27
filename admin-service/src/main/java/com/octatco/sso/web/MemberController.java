package com.octatco.sso.web;

import com.octatco.sso.applications.MemberFacade;
import com.octatco.sso.domains.member.Member;
import com.octatco.sso.infrastructures.jpa.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;
    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/member/{id}")
    public MemberDto.MemberResponse retrieveMember(@PathVariable("id") final Long id) {
        return MemberDto.MemberResponse.from(memberFacade.retrieveMemberInfo(id));
    }

    @PostMapping("/member")
    public Member createMember(@RequestBody final Member member) {
        MDC.put("X-USER-ID", member.getUsername());
        return memberJpaRepository.save(member);
    }
}
