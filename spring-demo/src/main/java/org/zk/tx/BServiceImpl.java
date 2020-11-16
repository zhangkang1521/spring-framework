package org.zk.tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zk.tx.dynamicdatasource.ReadOnlyDataSource;

public class BServiceImpl implements BService {

	private JdbcTemplate jdbcTemplate;

	private CService cService;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@ReadOnlyDataSource
	public void save() {

		jdbcTemplate.execute("update tb_user set username='b' where id = 2");

		 throw new RuntimeException("111");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setcService(CService cService) {
		this.cService = cService;
	}
}
