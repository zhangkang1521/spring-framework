package org.zk.tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CServiceImpl implements CService {

	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void save() {
		jdbcTemplate.execute("update tb_user set username='c' where id = 3");
//		throw new RuntimeException("ccc");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
