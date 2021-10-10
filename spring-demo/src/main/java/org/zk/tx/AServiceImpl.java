package org.zk.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zk.tx.dynamicdatasource.ReadOnlyDataSource;

public class AServiceImpl /*implements AService*/ {

	private JdbcTemplate jdbcTemplate;

	public static final Logger log = LoggerFactory.getLogger(AServiceImpl.class);

	private BService bService;
	private CService cService;


//	@Transactional
	public void save() throws Exception {
		log.info(">>>>>>>>>>invoke save");
		jdbcTemplate.execute("update tb_user set username='a' where id = 1");
		// bService.save();
		log.info(">>>>>>>>>>invoke save2");
		((AServiceImpl)AopContext.currentProxy()).save2();
//		throw new Exception("ss");
//		String str = jdbcTemplate.queryForObject("select username from tb_user where id = 1", String.class);
//		System.out.println(str);
//		if (true)
//			throw new RuntimeException("xx");

//		throw new RuntimeException("xx");
	}

	@Transactional
	public void save2() {
		jdbcTemplate.execute("update tb_user set username='b' where id = 1");
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setbService(BService bService) {
		this.bService = bService;
	}

	public void setcService(CService cService) {
		this.cService = cService;
	}
}
