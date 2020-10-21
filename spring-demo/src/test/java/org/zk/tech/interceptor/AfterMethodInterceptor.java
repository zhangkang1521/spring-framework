package org.zk.tech.interceptor;

public class AfterMethodInterceptor implements MethodInterceptor {

	@Override
	public void invoke(MyMethodInvocation myMethodInvocation) {
		myMethodInvocation.proceed();
		System.out.println("after");
	}
}
