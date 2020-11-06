package org.zk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.zk.domain.User;

@Configuration
//@ImportResource("classpath:applicationContext.xml")
//@Import(FooConfig.class)
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan(basePackages = "org.zk.service.impl")
@PropertySource("classpath:app.properties")
public class ApplicationConfig {

	@Autowired
	Environment environment;

	@Value("${test}")
	private String test;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// 使用 -Dspring.profiles.active=dev指定profile
	@Bean
	public User user() {
		String[] profiles = environment.getActiveProfiles();
//		System.out.println(environment.getProperty("test"));
		return new User();
	}



}
