package org.zk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


//@Configuration
//@ComponentScan("org.zk.service")
//@EnableTransactionManagement
//@EnableJpaRepositories("org.zk.repo")
public class JpaConfig {

	public static final Logger log = LoggerFactory.getLogger(JpaConfig.class);

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/zk");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}

	// 相当于SqlSessionFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		// 设置DataSource:
		entityManagerFactoryBean.setDataSource(dataSource);
		// 扫描指定的package获取所有entity class:
		entityManagerFactoryBean.setPackagesToScan("org.zk.entity");
		// 指定JPA的提供商是Hibernate:
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		// 设定特定提供商自己的配置:
		Properties props = new Properties();
		//props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		entityManagerFactoryBean.setJpaProperties(props);
		log.info("注入bean entityManagerFactory {}", entityManagerFactoryBean);
		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
