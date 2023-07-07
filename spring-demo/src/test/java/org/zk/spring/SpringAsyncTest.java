package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.async.AsyncConfig;
import org.zk.async.AsyncDemoService;

import java.util.concurrent.Future;

public class SpringAsyncTest {

	@Test
	public void testAsync() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
		AsyncDemoService demoService = ctx.getBean(AsyncDemoService.class);
		demoService.sayHello(1);
		System.in.read();
	}

	@Test
	public void testExhaust() throws Exception {
		// 会抛出 RejectedExecutionException
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
		AsyncDemoService demoService = ctx.getBean(AsyncDemoService.class);
		for (int i = 0; i < 16; i++) {
			demoService.sayHello(i);
		}
		System.in.read();
	}

	@Test
	public void testFuture() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
		AsyncDemoService demoService = ctx.getBean(AsyncDemoService.class);
		Future<String> future = demoService.testFuture("world");
		System.out.println(future.get());
	}
}
