package org.zk.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserService implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void register(String name) {
		System.out.println("用户" + name + "注册");
		applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
		applicationEventPublisher.publishEvent(new OtherEvent(name));
	}
}
