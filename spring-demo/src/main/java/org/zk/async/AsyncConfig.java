package org.zk.async;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangkang
 * @date 2023/7/6 10:38
 */
@Configuration
@EnableAsync
@ComponentScan(basePackages = "org.zk.async")
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 默认线程池使用SimpleAsyncTaskExecutor，为每个任务创建一个线程去执行
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        // 使用自定义线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("spring-demo-pool-");
        executor.initialize();
        return executor;
    }
}
