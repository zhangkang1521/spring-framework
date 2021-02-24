package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.zk.domain.User;
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

	@Test
	public void testSendObject() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("HelloWorldQueue", new User());
	}

	@Test
	public void testJmsTemplateSend() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.send("HelloWorldQueue", new MessageCreator() {
			@Override
			public javax.jms.Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage("{2}");
				textMessage.setStringProperty("anchorSendTraceId",  "vst_order");
				return textMessage;
			}
		});
	}




}
