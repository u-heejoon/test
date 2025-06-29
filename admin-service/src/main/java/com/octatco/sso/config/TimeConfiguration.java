package com.octatco.sso.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;
import java.util.TimeZone;

@Configuration
public class TimeConfiguration {

    @PostConstruct
    public void setTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")); // 기본 시간대를 서울로 설정
    }

    @Bean
    public Clock clock() {
        return Clock.system(ZoneId.of("Asia/Seoul")); // 기본은 시스템 시간
    }

}
