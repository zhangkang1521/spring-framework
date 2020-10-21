package org.zk.spring;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.zk.aop.*;

public class SpringTxTest {

	@Test
	public void testJdbcTemplate() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		jdbcTemplate.execute("update tb_user set username='111' where id = 1");
		ctx.close();
	}


}
