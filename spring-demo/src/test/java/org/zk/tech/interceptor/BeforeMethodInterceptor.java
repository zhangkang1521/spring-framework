package org.zk.tech.interceptor;

public class BeforeMethodInterceptor implements MethodInterceptor {

	@Override
	public void invoke(MyMethodInvocation myMethodInvocation) {
		System.out.println("before");
		myMethodInvocation.proceed();
	}
}
