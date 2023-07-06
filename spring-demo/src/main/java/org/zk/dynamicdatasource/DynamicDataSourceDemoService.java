package org.zk.dynamicdatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.zk.dynamicdatasource.support.ReadOnlyDataSource;

/**
 * @author zhangkang
 * @date 2023/7/6 9:57
 */
@Component
public class DynamicDataSourceDemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save() {
        jdbcTemplate.execute("update tb_user set username='a' where id = 1");
    }

    @ReadOnlyDataSource
    public void query() {
        String username = jdbcTemplate.queryForObject("select username from tb_user where id = 1", String.class);
    }
}
