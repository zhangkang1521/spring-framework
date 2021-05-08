package org.zk.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * bean初始化前后调用
 */
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {



    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("*** bean初始化前置处理" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("*** bean初始化后置处理" + beanName);
        return null;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
