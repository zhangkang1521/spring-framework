package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * bean实例化前后调用
 * Created by Administrator on 6/8/2018.
 */
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {



    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean前置处理" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean后置处理" + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
