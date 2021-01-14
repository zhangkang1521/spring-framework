package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.zk.tx.AService;

public class SpringJmsTest {

	@Test
	public void testReceive() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		System.in.read();
	}




}
