package com.octatco.sso.domains;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public abstract class RequestByAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // 1순위: getAuditor(), 2순위: getDefaultAuditor(), 최종 fallback: "SYSTEM"
        String resolved = StringUtils.defaultIfBlank(
                getAuditor(),
                StringUtils.defaultIfBlank(getDefaultAuditor(), "SYSTEM")
        );
        return Optional.of(resolved);
    }


    protected abstract String getAuditor();

    protected abstract String getDefaultAuditor();
}

