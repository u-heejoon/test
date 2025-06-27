package com.octatco.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(
//        auditorAwareRef = "customAuditorAware"
//        dateTimeProviderRef = "dateTimeProvider"
)
public class AwareConfiguration {

}
