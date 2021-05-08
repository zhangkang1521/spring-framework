package org.zk.spring;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.aop.*;
import org.zk.aop.introduce.Monitorable;

public class SpringAopTest {

	@Test
	public void testAop() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
		MyTarget myTarget = ctx.getBean(MyTarget.class);
		myTarget.sayWorld();
	}

	@Test
	public void testIntroduce() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
		MyTarget myTarget = (MyTarget) ctx.getBean("targetProxy");
		((Monitorable)myTarget).setMonitorActive(true); // 引介增强添加的方法
		myTarget.sayHello();
	}

	@Test
	public void test1() {
		MyTarget myTarget = new MyTargetImpl();
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(myTarget);
//		proxyFactoryBean.setInterfaces(MyTarget.class);
		proxyFactoryBean.addAdvice(new MyAfterAdvice()); // 默认pointcut是true
		proxyFactoryBean.addAdvice(new MyBeforeAdvice());

		MyTarget proxyTarget = (MyTarget) proxyFactoryBean.getObject();
		proxyTarget.sayHello();
	}

	@Test
	public void testPointCut() {
		MyTarget myTarget = new MyTargetImpl();
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(myTarget);
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public * org.zk.aop.MyTargetImpl.sayHello())");
		FilteredAdvisor sellBeforeAdvisor = new FilteredAdvisor(pointcut, new MyBeforeAdvice());
		//添加到FactoryBean中
		proxyFactoryBean.addAdvisor(sellBeforeAdvisor);
		MyTarget proxyTarget = (MyTarget) proxyFactoryBean.getObject();
		proxyTarget.sayHello();
//		proxyTarget.sayWorld();
	}
}
