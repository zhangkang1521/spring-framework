package org.zk.spring;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.zk.aop.*;

public class AopTest {

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
		proxyTarget.sayWorld();
	}
}
