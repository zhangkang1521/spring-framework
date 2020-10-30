package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.zk.tx.AService;

public class SpringTxTest {

	@Test
	public void testJdbcTemplate() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		jdbcTemplate.execute("update tb_user set username='111' where id = 1");
		ctx.close();
	}

	@Test
	public void testTx() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		AService userJdbcService = ctx.getBean(AService.class);
		userJdbcService.save();
	}


}
