package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.zk.config.AppConfig;
import org.zk.config.DemoConfig;
import org.zk.config.FooConfig;
import org.zk.domain.User;


public class SpringAnnotationTest {

	@Test
	public void testAnnotationCtx() {
		// 注解启动Spring，使用 ConfigurationClassPostProcessor 容器注册后处理器注册beanDefinition，
		// 该类使用AnnotatedBeanDefinitionReader读取BeanDefinition
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
		// Object userService = ctx.getBean("userService");
//		User user2 = ctx.getBean(User.class);
//		System.out.println(user.getUsername());
		for (String beanName : ctx.getBeanDefinitionNames()) {
			if (beanName.startsWith("org.springframework")) {
				continue;
			}
			System.out.println(beanName + " => " + ctx.getBean(beanName));
		}
		ctx.close();
	}



	@Test
	public void testEnv() {
		// 系统属性 -Dtest=fromVM
		System.out.println(System.getProperty("test"));
		// 系统属性
		System.out.println(System.getProperty("user.dir"));
		// 环境变量
		System.out.println(System.getenv("M2_HOME"));

//		System.getenv().forEach((k, v) -> {
//			System.out.println(k + " => " + v);
//		});

	}
}
