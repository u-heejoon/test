package com.sso.config;

import com.sso.domains.member.Member;
import com.sso.infrastructures.jpa.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * please explain class!
 *
 * @author :Uheejoon
 * @date :2025-06-27 오전 1:14
 */
@Configuration
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private final MemberJpaRepository repository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        repository.save(
          Member.builder()
            .username("희준")
            .build()
        );
    }
}
