package org.zk.config;

import org.springframework.context.annotation.*;
import org.zk.domain.User;

@Configuration
@ComponentScan(basePackages = "org.zk.service.impl")
@ImportResource("classpath:applicationContext.xml")
@Import(FooConfig.class)
//@Import(MyRegister.class)
//@Import(MyImportSelector.class)
public class ApplicationConfig {

	@Bean
	public User user() {
		return new User();
	}
}
