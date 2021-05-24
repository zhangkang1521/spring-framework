package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.AppConfig;
import org.zk.domain.User;

public class SpringAnnotationTest {

	@Test
	public void testAnnotationCtx() {
		// 注解启动Spring，使用 ConfigurationClassPostProcessor 后置处理器注册beanDefinition，
		// 该类使用AnnotatedBeanDefinitionReader读取BeanDefinition
		// ConfigurationClassBeanDefinitionReader.ConfigurationClassBeanDefinition 继承自 RootBeanDefinition
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = ctx.getBean(User.class);
		System.out.println(user.getUsername());
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
