package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * bean实例化前后调用
 * Created by Administrator on 6/8/2018.
 */
public class MyBeanPostProcessor2 implements BeanPostProcessor, PriorityOrdered {



    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization 2");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
