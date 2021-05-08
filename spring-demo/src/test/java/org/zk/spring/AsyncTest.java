package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.aop.MyTarget;
import org.zk.config.ApplicationConfig;
import org.zk.config.AsyncConfig;
import org.zk.domain.User;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTest {

	@Test
	public void testAsync() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AsyncConfig.class);
		MyTarget myTarget = ctx.getBean(MyTarget.class);
//		Future future = myTarget.sayHello();
//		try {
//			System.out.println(future.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
	}
}
