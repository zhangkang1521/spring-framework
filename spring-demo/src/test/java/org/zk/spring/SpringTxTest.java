package org.zk.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.zk.tx.AService;
import org.zk.tx.AServiceImpl;

public class SpringTxTest {

	@Test
	public void testJdbcTemplate() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		jdbcTemplate.execute("update tb_user set username='111' where id = 1");
		ctx.close();
	}

	@Test
	public void testTx() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		AServiceImpl aService = ctx.getBean(AServiceImpl.class);
		aService.save();
	}

	@Test
	public void testTransactionTemplate() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		TransactionTemplate transactionTemplate = ctx.getBean(TransactionTemplate.class);
		transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				status.setRollbackOnly();
				return null;
				// throw new RuntimeException("xx");
				// return null;
			}
		});
	}


}
