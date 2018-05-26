package org.zk.service;

import org.springframework.beans.factory.FactoryBean;
import org.zk.domain.User;

/**
 * Created by Administrator on 5/26/2018.
 */
public class UserFactoryBean implements FactoryBean<User> {

    public User getObject() throws Exception {
        return new User(1, "zk");
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
