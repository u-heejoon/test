package com.octatco.sso.config;

import org.springframework.boot.task.SimpleAsyncTaskExecutorBuilder;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Duration;

/**
 * Thread Pool config
 */
@EnableAsync
@Configuration
@EnableScheduling
public class ThreadPoolConfiguration {
    @Primary
    @Bean(name = "asyncThreadPoolExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(ThreadPoolTaskExecutorBuilder builder) {
        return builder
          .corePoolSize(10)
          .maxPoolSize(100)
          .queueCapacity(50)
          .allowCoreThreadTimeOut(true)
          .keepAlive(Duration.ofMinutes(1L))
          .threadNamePrefix("sso-async-")
//          .taskDecorator(taskDecorator())
          .build();
    }

    @Bean
     public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor(SimpleAsyncTaskExecutorBuilder builder) {
        return builder
          .threadNamePrefix("sso-simple-async-")
          .build();
    }


    @Bean
    public TaskDecorator taskDecorator() {
        return new ThreadLocalCopyTaskDecorator();
    }

    @Bean
    @Primary
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(ThreadPoolTaskSchedulerBuilder builder) {
        return builder
          .poolSize(10)
          .threadNamePrefix("sso-scheduler-")
          .build();
    }
}
