package org.zk.spring;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.entity.UserEntity;

public class SpringHibernateTest {

	@Test
	public void testQuery() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		UserEntity user = (UserEntity) sessionFactory.openSession().get(UserEntity.class, 1);
	}
}
