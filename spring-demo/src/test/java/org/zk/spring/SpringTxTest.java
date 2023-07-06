package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.zk.tx.AService;
import org.zk.tx.AServiceImpl;
import org.zk.tx.TxConfig;

public class SpringTxTest {


	@Test
	public void txXml() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx.xml");
		AServiceImpl aService = ctx.getBean(AServiceImpl.class);
		aService.save();
	}

	@Test
	public void txAnnotation() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TxConfig.class);
		AServiceImpl aService = ctx.getBean(AServiceImpl.class);
		aService.save();
	}

	@Test
	public void testTransactionTemplate() throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TxConfig.class);
		TransactionTemplate transactionTemplate = ctx.getBean(TransactionTemplate.class);
		AServiceImpl aService = ctx.getBean(AServiceImpl.class);

		transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				aService.save3();
				return true;
			}
		});
	}

}
