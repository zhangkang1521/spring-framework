package org.zk.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.zk.domain.User;

public class BeanFactoryTest {

	@Test
	public void testXmlBeanFactory() throws Exception {
		// BeanFactory = DefaultListableBeanFactory + XmlBeanDefinitionReader
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		User user = (User)beanFactory.getBean("user");
		User user2 = (User)beanFactory.getBean("user");
//		System.out.println(user);
	}
}
