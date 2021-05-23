package org.zk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.zk.annotation.EnableUser;
import org.zk.domain.Order;
import org.zk.domain.User;

import java.util.concurrent.Executor;

// 引入properties配置文件，放入environment中
//@PropertySource("classpath:jdbc.properties")

// 引入xml配置
// @ImportResource("classpath:applicationContext.xml")

// 直接引入配置类，配置类也会成为一个bean
//@Import(FooConfig.class)
// 实现ImportSelector接口，返回配置类名的字符串
//@Import(MyImportSelector.class)
// 实现容器注册接口
//@Import(MyImportBeanDefinitionRegistrar.class)

// 对@Import进行包装，封装底层细节
//@EnableAsync

// 包扫描
//@ComponentScan(basePackages = "org.zk.aop")
@Configuration
public class ApplicationConfig {


	// 命令参数(getProperties) > 环境变量(getEnv) > properties 文件
	private String test;

//	@Value("${jdbc.username}")
//	@Value("#{user.username}")
	public void setTest(String test) {
		this.test = test;
	}

	// 容器后处理器，处理占位符，PropertyPlaceholderConfigurer不行，这个类不会从environment中读取配置
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}


	@Bean
	public User user() {
		User user = new User();
		user.setUsername("zk1");
		return user;
	}


//	@Bean(name = "order2")
//	public Order order2() {
//		Order order1 = new Order();
//		order1.setId(2);
//		return order1;
//	}

//	@Bean
//	public User user0() {
//		return new User();
//	}





}
