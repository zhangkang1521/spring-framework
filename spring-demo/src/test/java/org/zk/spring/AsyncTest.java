package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.aop.MyTarget;
import org.zk.config.ApplicationConfig;
import org.zk.domain.User;

public class AsyncTest {

	@Test
	public void testAsync() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		MyTarget myTarget = (MyTarget) ctx.getBean("myTarget");
		myTarget.sayHello();
		myTarget.sayWorld();
	}
}
