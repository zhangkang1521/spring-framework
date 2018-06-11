package org.zk.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 单例的bean才执行destroy方法
 * @PostConstrct @PreDestroy 原理是使用 {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor}
 * Created by Administrator on 6/9/2018.
 */
public class LifeCycle implements InitializingBean, DisposableBean{

    public LifeCycle() {
        System.out.println("LifeCycle()");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanPostProcessor调用@PostConstruct注释的方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanPostProcessor调用@PreDestroy注释的方法");
    }

    public void destroy() throws Exception {
        System.out.println("执行DisposableBean.destroy()回调方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean.afterPropertiesSet()回调方法");
    }

    public void xmlInit() {
        System.out.println("执行xml配置的init-method");
    }

    public void xmlDestroy() {
        System.out.println("执行xml配置的destroy-method");
    }
}
