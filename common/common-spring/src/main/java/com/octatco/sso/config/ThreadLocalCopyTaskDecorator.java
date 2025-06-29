package com.octatco.sso.config;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * Thread간 MDC 데이터를 공유하기 위한 decorator <br/>
 * 로깅용
 */
public class ThreadLocalCopyTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {

        Map<String, String> map = MDC.getCopyOfContextMap();

        return () -> {
            if (map != null) {
                MDC.setContextMap(map);
            }
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }

        };
    }
}
