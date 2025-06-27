package com.octatco.sso.config;

import com.octatco.sso.domains.RequestByAuditorAware;
import org.springframework.stereotype.Component;

//@Component
public class CustomAuditorAware extends RequestByAuditorAware {
    @Override
    protected String getAuditor() {
        return "hi";
    }

    @Override
    protected String getDefaultAuditor() {
        return "";
    }
}
