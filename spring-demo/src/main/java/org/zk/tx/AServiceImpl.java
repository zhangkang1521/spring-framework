package org.zk.tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AServiceImpl implements AService {

	private JdbcTemplate jdbcTemplate;

	private BService bService;
	private CService cService;

//	@Transactional
	public void save() {
		jdbcTemplate.execute("update tb_user set username='a' where id = 1");
//		if (true)
//			throw new RuntimeException("xx");

		bService.save();
//		throw new RuntimeException("xx");
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
