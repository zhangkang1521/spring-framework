package org.zk.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.zk.domain.User;
import org.zk.tx.AService;

import javax.jms.*;

public class SpringJmsTest {

	private Logger log = LoggerFactory.getLogger(SpringJmsTest.class);


	/**
	 * http://localhost:8161 访问，查看是否发送成功
	 * @throws Exception
	 */
	@Test
	public void send() throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("demo-queue");
		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage("hello2");

		producer.send(message);

		session.close();
		connection.close();
	}

	@Test
	public void receive() throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		connection.start(); // 消费端必须start
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("demo-queue");
		MessageConsumer consumer = session.createConsumer(destination);

//		consumer.setMessageListener(new MessageListener() {
//			@Override
//			public void onMessage(Message message) {
//				 ActiveMQ Session Task-1
//				log.info("收到消息");
//			}
//		});
//		System.in.read();

		Message message = consumer.receive();
		System.out.println(((TextMessage)message).getText());

		session.close();
		connection.close();


	}

	@Test
	public void jmsTemplateSend() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("my-queue", "hello,world");
	}

	@Test
	public void jmsTemplateReceive() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		Message message = jmsTemplate.receive("my-queue");
		System.out.println(((TextMessage)message).getText());
	}

	@Test
	public void messageListener() throws Exception {
		// 使用 DefaultMessageListenerContainer 线程池消费
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms-consumer.xml");
		System.in.read();
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

	@Test
	public void testSendObject() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jms.xml");
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("HelloWorldQueue", new User());
	}




}
