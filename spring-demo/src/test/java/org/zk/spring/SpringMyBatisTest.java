package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zk.dao.UserDao;
import org.zk.domain.User;
import org.zk.service.UserService;

import static org.junit.Assert.*;

public class SpringMyBatisTest {

	@Test
	public void testDao() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserDao userDao = ctx.getBean(UserDao.class);
		User user = userDao.findById(1);
	}

	@Test
	public void testService() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		UserService userService = ctx.getBean(UserService.class);
		userService.update();
		ctx.close();
	}

}