package org.zk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.zk.dao.UserDao;

import javax.sql.DataSource;


@Configuration
@ComponentScan("org.zk.service")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/zk");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(new Resource[]{new ClassPathResource("mappers/UserMapper.xml")});
		return sqlSessionFactoryBean.getObject();
	}

	// 由配置后处理器注册，如何触发他的容器注册
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setBasePackage("org.zk.dao");
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//		return mapperScannerConfigurer;
//	}

	@Bean
	public UserDao userDao(SqlSessionFactory sqlSessionFactory) throws Exception {
		MapperFactoryBean<UserDao> mapperFactoryBean = new MapperFactoryBean<>();
		mapperFactoryBean.setMapperInterface(UserDao.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
		return mapperFactoryBean.getObject();
	}


}
