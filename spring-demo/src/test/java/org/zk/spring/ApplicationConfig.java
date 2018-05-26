package org.zk.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zk.domain.User;

/**
 * Created by Administrator on 4/19/2018.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public User getUser() {
        User user = new User();
        return user;
    }
}
