package com.octatco.sso.infrastructures;

public interface NotificationService {
    <T> void publishEvent(T data);
}
