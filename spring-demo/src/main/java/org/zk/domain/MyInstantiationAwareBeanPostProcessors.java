package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * Created by Administrator on 7/22/2018.
 */
public class MyInstantiationAwareBeanPostProcessors implements InstantiationAwareBeanPostProcessor {

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("=== before instantiation ===");
        //return new Car();
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("=== after instantiation ===");
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
