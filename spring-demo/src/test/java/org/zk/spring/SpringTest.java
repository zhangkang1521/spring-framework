package org.zk.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.zk.domain.Car;
import org.zk.domain.User;
import org.zk.service.SayHelloService;
import org.zk.service.UserService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;


/**
 * Created by Administrator on 5/22/2018.
 */
public class SpringTest {

    @Test
    public void testClassPathCtx() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object user1 = ctx.getBean("user1");
        Object user2 = ctx.getBean("user2");
    }

    @Test
    public void testXmlBeanFactory() throws Exception {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User user = (User)beanFactory.getBean("user");
        System.out.println(user);
    }


    @Test
    public void testLookUpMethod() {
        // https://www.cnblogs.com/ViviChan/p/4981619.html
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        // 返回的userService是个代理
        for (int i = 0; i < 3; i++) {
            System.out.println(userService.getNewUser());
        }
    }

    @Test
    public void testReplacedMethod() {
        // http://www.cnblogs.com/mjorcen/p/3647234.html
        // 改变方法逻辑
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SayHelloService sayHelloService = ctx.getBean("sayHelloService", SayHelloService.class);
        sayHelloService.sayHello();
    }

    @Test
    public void testFileSystemCtx() {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("E:/applicationContext.xml");
    }

    @Test
    public void testAnnotationCtx() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }


}
