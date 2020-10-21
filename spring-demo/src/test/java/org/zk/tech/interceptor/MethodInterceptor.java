package org.zk.tech.interceptor;

public interface MethodInterceptor {

	void invoke(MyMethodInvocation myMethodInvocation);
}
