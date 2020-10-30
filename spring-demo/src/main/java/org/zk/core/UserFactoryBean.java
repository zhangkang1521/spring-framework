package org.zk.core;

import org.springframework.beans.factory.FactoryBean;
import org.zk.domain.User;

/**
 * Created by Administrator on 5/26/2018.
 */
public class UserFactoryBean implements FactoryBean<User> {

    public User getObject() throws Exception {
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
