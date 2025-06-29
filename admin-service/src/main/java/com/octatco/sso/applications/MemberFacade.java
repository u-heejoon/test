package com.octatco.sso.applications;

import com.octatco.sso.domains.member.MemberInfo;
import com.octatco.sso.domains.member.MemberService;
import com.octatco.sso.infrastructures.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final NotificationService notificationService;
    private final MemberService memberService;

    public MemberInfo.Main retrieveMemberInfo(final Long id) {
        final MemberInfo.Main main = memberService.retrieveMember(id);
        notificationService.publishEvent(main);
        return main;
    }

}
