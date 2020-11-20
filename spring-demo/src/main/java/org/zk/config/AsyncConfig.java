package org.zk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

@Configuration
@EnableAsync
@ComponentScan("org.zk.aop")
public class AsyncConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		// 使用自定义线程池
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("spring-demo-pool-");
//		executor.setThreadFactory(new ThreadFactory() {
//			@Override
//			public Thread newThread(Runnable r) {
//				Thread thread = executor.newThread(r);
//				thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//					@Override
//					public void uncaughtException(Thread t, Throwable e) {
//						if (e != null) {
//							e.printStackTrace();
//						}
//					}
//				});
//				return thread;
//			}
//		});
		executor.initialize();
		return executor;
	}
}
