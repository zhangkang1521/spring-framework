package org.zk.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.*;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * 将bean中属性配置为shit换成***
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
            PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                Object obj = propertyValue.getValue();
                if (obj instanceof TypedStringValue) {
                    String str = ((TypedStringValue)obj).getValue();
                    if ("shit".equals(str)) {
                        mutablePropertyValues.add(propertyValue.getName(), "***");
                    }
                }
            }
        }
    }


}
