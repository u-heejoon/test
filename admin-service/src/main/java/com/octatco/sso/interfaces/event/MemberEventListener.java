package com.octatco.sso.interfaces.event;

import com.octatco.sso.domains.member.MemberInfo;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class MemberEventListener {

    private final Logger log = getLogger(this.getClass().getName());

    @Async("simpleAsyncTaskExecutor")
    @EventListener
    public void MemberLogging(final MemberInfo.Main member) {
        final String username = MDC.get("X-USER-ID");
//        log.info("event member {}, {}", member, username);
    }

}
