package org.zk.tech.interceptor;

import org.springframework.aop.support.AopUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyMethodInvocation {

	private Object target;
	private Method method;
	private Object[] arguments;


	private List<MethodInterceptor> methodInterceptors;
	private int current = -1;

	public MyMethodInvocation(Object target, Method method, Object[] arguments, List<MethodInterceptor> methodInterceptors) {
		this.target = target;
		this.method = method;
		this.arguments = arguments;
		this.methodInterceptors = methodInterceptors;
	}

	public void proceed() {
		if (current >= methodInterceptors.size() - 1) {
			try {
				method.invoke(target, arguments);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return;
		}
		MethodInterceptor methodInterceptor = methodInterceptors.get(++current);
		methodInterceptor.invoke(this);
	}
}
