package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.ApplicationConfig;
import org.zk.domain.User;
import org.zk.service.UserService;

public class SpringAnnotationTest {

	@Test
	public void testAnnotationCtx() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User user = userService.getNewUser();
//		System.out.println(userService.getNewUser());
		ctx.close();
	}
}
