package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.Set;

/**
 * 敏感词汇处理
 * Created by Administrator on 8/6/2018.
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> obscenties;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                // visitBeanDefinition时回调
                @Override
                public String resolveStringValue(String strVal) {
                    // 如果属性值是敏感词，替换成***，配置文件
                    // PropertyPlaceholderConfigurer 原理类似，将${xxx}替换成配置文件的内容
                    if (isObscenity(strVal)) {
                        return "***";
                    } else {
                        return strVal;
                    }
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(beanDefinition);
        }
    }

    private boolean isObscenity(String strVal) {
        return obscenties.contains(strVal);
    }

    public void setObscenties(Set<String> obscenties) {
        this.obscenties = obscenties;
    }
}
