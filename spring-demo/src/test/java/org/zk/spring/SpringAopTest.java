package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.aop.AopConfig;
import org.zk.aop.MyTarget;

public class SpringAopTest {

	@Test
	public void testAop() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
		MyTarget myTarget = ctx.getBean(MyTarget.class);
		myTarget.sayHello();
//		myTarget.sayWorld();
	}

	@Test
	public void annotationAop() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		MyTarget myTarget = ctx.getBean(MyTarget.class);
		myTarget.sayHello();
//		myTarget.sayWorld();
	}

}
