package com.octatco.sso.config;

import com.octatco.sso.domains.DefaultRequestByAuditorAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * <p>
 *  AuditorAware Default 설정
 * </p>
 */
@Configuration
public class DefaultAuditAwareConfiguration {

    @Bean
    @ConditionalOnMissingBean(AuditorAware.class)
    public AuditorAware<String> auditorAware() {
        return new DefaultRequestByAuditorAware();
    }

}
