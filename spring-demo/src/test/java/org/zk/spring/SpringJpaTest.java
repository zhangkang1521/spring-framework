package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.JpaConfig;
import org.zk.entity.UserEntity;
import org.zk.service.UserService;

public class SpringJpaTest {

	@Test
	public void test1() {
		// PersistenceAnnotationBeanPostProcessor 支持@PersistenceContext @PersistenceUnit
		// SharedEntityManagerCreator$SharedEntityManagerInvocationHandler 对@PersistenceContext注入的EntityManager进行代理
		// spring-boot能使用@Autowired注入
		// 是因为EntityManagerBeanDefinitionRegistrarPostProcessor注入了SharedEntityManagerCreator factory-method:createSharedEntityManager
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		UserEntity user = userService.find(1);
		System.out.println(user);
	}
}
