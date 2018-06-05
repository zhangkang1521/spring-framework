package org.zk.domain;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 6/2/2018.
 */
public class UserFactoryBean implements FactoryBean<User> {

    public User getObject() throws Exception {
        System.out.println("===");
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
