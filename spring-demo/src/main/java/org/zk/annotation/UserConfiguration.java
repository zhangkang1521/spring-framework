package org.zk.annotation;

import org.springframework.context.annotation.Bean;
import org.zk.domain.User;

public class UserConfiguration {

	@Bean
	public User user() {
		return new User();
	}
}
