package org.zk.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AServiceImpl /*implements AService*/ {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final Logger log = LoggerFactory.getLogger(AServiceImpl.class);

	private BService bService;


	@Transactional
	public void save() {
		log.info(">>>>>>>>>>invoke save");
		jdbcTemplate.execute("update tb_user set username='a' where id = 1");
//		throw new RuntimeException("xxx");
//		((AServiceImpl)AopContext.currentProxy()).save2();
	}

	@Transactional
	public void save2() {
		jdbcTemplate.execute("update tb_user set username='b' where id = 1");
	}

	public void save3() {
		jdbcTemplate.execute("update tb_user set username='333' where id = 1");
//		throw new RuntimeException("xxx");
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setbService(BService bService) {
		this.bService = bService;
	}

}
