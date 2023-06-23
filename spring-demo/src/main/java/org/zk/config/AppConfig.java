package org.zk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceArrayPropertyEditor;
import org.zk.dao.UserDao;

import javax.sql.DataSource;
import java.beans.PropertyEditor;


@Configuration
//@MapperScan("org.zk.dao")
//@ComponentScan("org.zk.temp")
public class AppConfig {

//	@Value("classpath:mappers/*.xml")
//	private Resource[] mapperResources;

//	@Bean
//	public DataSource dataSource() {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/zk");
//		dataSource.setUsername("root");
//		dataSource.setPassword("123456");
//		return dataSource;
//	}

//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		// 配置文件string会自动转换到Resource[]
////		PropertyEditor editor = new ResourceArrayPropertyEditor();
////		editor.setAsText("classpath:mappers/*.xml");
////		Resource[] resources = (Resource[]) editor.getValue();
//		sqlSessionFactoryBean.setMapperLocations(mapperResources);
//		return sqlSessionFactoryBean.getObject();
//	}

	// 不能这么配，因为这里是由ConfigurationClassPostProcessor注册的，不可能再回调这个bean的容器注册方法
	// 使用ImportBeanDefinitionRegistrar进行注册
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setBasePackage("org.zk.dao");
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//		return mapperScannerConfigurer;
//	}

//	@Bean
//	public UserDao userDao(SqlSessionFactory sqlSessionFactory) throws Exception {
//		MapperFactoryBean<UserDao> mapperFactoryBean = new MapperFactoryBean<>();
//		mapperFactoryBean.setMapperInterface(UserDao.class);
//		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//		return mapperFactoryBean.getObject();
//	}


}
