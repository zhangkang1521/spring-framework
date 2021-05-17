package org.zk.core;

import org.springframework.beans.factory.FactoryBean;
import org.zk.domain.User;

/**
 * Created by Administrator on 5/26/2018.
 */
public class UserFactoryBean implements FactoryBean<User> {

    public User getObject() throws Exception {
        // 每次getBean都会调用，单例中存的是UserFactoryBean
        // 所以Mybatis的SqlSessionFactoryBean将构建SqlSessionFactory放到初始化方法中
        return new User();
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        // 是否单例：getObject创建的对象会被缓存
        return true;
    }
}
