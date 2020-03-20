package org.zk.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.zk.annotation.EnableUser;
import org.zk.aop.MyTarget;
import org.zk.aop.MyTargetImpl;
import org.zk.domain.User;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
@EnableAsync
@EnableUser
public class ApplicationConfig {

    @Bean(name = "myTarget")
    public MyTarget getTarget() {
       return new MyTargetImpl();
    }

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10000);
        executor.setThreadNamePrefix("my-task-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
