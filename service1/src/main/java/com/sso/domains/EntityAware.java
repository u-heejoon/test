package com.sso.domains;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * please explain class!
 *
 * @author :Uheejoon
 * @date :2025-06-27 오전 1:18
 */
@Component
public class EntityAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable("HEEJOON");
    }
}
