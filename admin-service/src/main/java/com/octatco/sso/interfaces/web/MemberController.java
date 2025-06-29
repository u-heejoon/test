package com.octatco.sso.interfaces.web;

import com.octatco.sso.aop.SkipCommonResponse;
import com.octatco.sso.applications.MemberFacade;
import com.octatco.sso.domains.member.Member;
import com.octatco.sso.infrastructures.jpa.MemberJpaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping("/member")
//    public ResponseEntity<Long> createMember(@RequestBody final Member member) {
//        MDC.put("X-USER-ID", member.getUsername());
//        return ResponseEntity.status(201).body(memberJpaRepository.save(member).getId());
//    }
    @PostMapping("/member")
    public String createMember(@Valid @RequestBody final Member member) {
        return memberJpaRepository.save(member).getUsername();
    }
}
