package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.zk.tx.AService;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SpringJmsTest {



	@Test
	public void testReceive() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		System.in.read();
	}

	@Test
	public void testSend() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("my-queue", "hello,world");
	}




}
