package com.oc.channel.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by tigershome on 2020/4/5.
 */
@Configuration
@EnableAsync
public class AsyncCongifuration {

    @Bean("taskExector")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Core Thread number, they are initialized when the pool is launched
        executor.setCorePoolSize(5);
        // Max Thread number, apply more thread when the queue is full
        executor.setMaxPoolSize(10);
        // Queue capacity, used to execute the task
        executor.setQueueCapacity(10);
        // the duration a thread can be free, if the number exceed the core thread number, the free thread would be destroyed after alive time
        executor.setKeepAliveSeconds(60);
        // the thread pool prefix
        executor.setThreadNamePrefix("channel-thread-");
        executor.initialize();
        return executor;

    }
}
