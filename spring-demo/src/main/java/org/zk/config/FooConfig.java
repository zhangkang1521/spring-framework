package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zk.domain.User;

@Configuration
public class FooConfig {

	@Bean(name = "fooUser")
	public User user() {
		return new User();
	}
}
