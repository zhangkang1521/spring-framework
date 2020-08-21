package org.zk.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.zk.domain.Car;
import org.zk.domain.User;

import java.beans.PropertyDescriptor;

/**
 * bean实例化处后置处理器
 */
public class MyInstantiationAwareBeanPostProcessors implements InstantiationAwareBeanPostProcessor {

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("=== before instantiation ===");
//        return new User();
        // 如果有返回值，则不会再调用构造方法构造实际的bean
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("=== after instantiation ===");
        // 返回false代表不需要依赖注入
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("调用postProcessPropertyValues");
        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
