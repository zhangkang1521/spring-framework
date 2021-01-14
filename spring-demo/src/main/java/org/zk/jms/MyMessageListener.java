package org.zk.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

	private static Logger log = LoggerFactory.getLogger(MyMessageListener.class);

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage)message;
			log.info("收到消息：{}", textMessage.getText());
		} catch (JMSException e) {
			log.error("处理消息失败", e);
		}
	}
}
