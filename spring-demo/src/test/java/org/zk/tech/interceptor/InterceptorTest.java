package org.zk.tech.interceptor;

import org.zk.aop.MyTarget;
import org.zk.aop.MyTargetImpl;

import java.lang.reflect.Method;
import java.util.Arrays;

public class InterceptorTest {

	public static void main(String[] args) throws Exception {
		// aop代理执行链
		MyTarget myTarget = new MyTargetImpl();
		Method method = MyTarget.class.getMethod("sayHello", null);
		MethodInterceptor before = new BeforeMethodInterceptor();
		MethodInterceptor after = new AfterMethodInterceptor();
		MyMethodInvocation myMethodInvocation = new MyMethodInvocation(myTarget, method, null, Arrays.asList(after, before));
		myMethodInvocation.proceed();
	}
}
