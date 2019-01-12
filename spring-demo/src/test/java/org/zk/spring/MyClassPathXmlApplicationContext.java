package org.zk.spring;

import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 8/3/2018.
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }


    protected void initPropertySources() {
        // 验证系统必须要的环境变量
        getEnvironment().setRequiredProperties("java.version");
        getEnvironment().setRequiredProperties("M2_HOME");
    }

    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        this.setAllowCircularReferences(true);
        this.setAllowBeanDefinitionOverriding(false);
        super.customizeBeanFactory(beanFactory);
    }
}
