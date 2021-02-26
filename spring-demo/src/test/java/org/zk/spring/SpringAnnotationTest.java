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
		ApplicationConfig applicationConfig = ctx.getBean(ApplicationConfig.class);
		System.out.println(applicationConfig);
//		UserService userService = ctx.getBean(UserService.class);
//		User user = userService.getNewUser();
//		System.out.println(userService.getNewUser());
		ctx.close();
	}

	@Test
	public void testEnv() {
		// -Dtest=fromVM
		System.out.println(System.getProperty("test"));
		// 系统属性
		System.out.println(System.getProperty("user.dir"));
		// 环境变量
		System.out.println(System.getenv("test"));

//		System.getenv().forEach((k, v) -> {
//			System.out.println(k + " => " + v);
//		});

	}
}
