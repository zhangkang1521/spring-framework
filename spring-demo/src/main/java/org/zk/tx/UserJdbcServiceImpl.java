package org.zk.tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserJdbcServiceImpl implements UserJdbcService {

	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void save() {
		jdbcTemplate.execute("update tb_user set username='111' where id = 1");
//		if (true)
//			throw new RuntimeException("xx");
		jdbcTemplate.execute("update tb_user set username='222' where id = 2");
	}











	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
