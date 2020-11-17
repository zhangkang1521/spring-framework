package org.zk.aop.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IntroductionMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

	private ThreadLocal<Boolean> isMonitor = new ThreadLocal<Boolean>();

	{
		isMonitor.set(false);
	}

	@Override
	public void setMonitorActive(boolean active) {
		isMonitor.set(active);
	}


	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		if (isMonitor.get()) {
			System.out.println("=====before====");
			obj = super.invoke(mi);
			System.out.println("=====end====");
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
}
