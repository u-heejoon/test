package com.octatco.sso.domains;

import org.slf4j.MDC;

public class DefaultRequestByAuditorAware extends RequestByAuditorAware {

    public static final String USER_TRACE_ID = "X-USER-ID";

    @Override
    protected String getAuditor() {
        return MDC.get(USER_TRACE_ID);
    }

    @Override
    protected String getDefaultAuditor() {
        return "SYSTEM";
    }
}
