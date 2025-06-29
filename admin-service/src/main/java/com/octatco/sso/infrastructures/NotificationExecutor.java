package com.octatco.sso.infrastructures;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationExecutor implements NotificationService{

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public <T> void publishEvent(final T data) {
        eventPublisher.publishEvent(data);
    }
}
