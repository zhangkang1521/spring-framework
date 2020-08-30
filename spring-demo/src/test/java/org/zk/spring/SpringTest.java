package org.zk.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.zk.config.ApplicationConfig;
import org.zk.core.MyString2DateConverter;
import org.zk.domain.User;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Created by Administrator on 5/22/2018.
 */
public class SpringTest {

    @Test
    public void testClassPathCtx() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ctx.getBean("user0");
        System.out.println(user.getBirthday());
        ctx.close();
    }

    @Test
    public void testXmlBeanFactory() throws Exception {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        User user = (User)beanFactory.getBean("user");
        System.out.println(user.getUsername());
    }


    @Test
    public void testFileSystemCtx() {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("E:/applicationContext.xml");
    }

    @Test
    public void testAnnotationCtx() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        User user = (User)ctx.getBean("user1");
        System.out.println(user);
    }

    @Test
    public void testMessage() {
        // 国际化
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object[] params = {"Mary"};
        System.out.println(ctx.getMessage("test", params, Locale.US));
        System.out.println(ctx.getMessage("test", params, Locale.CHINA));
    }

    @Test
    public void testEvent() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        org.zk.event.UserService userService = (org.zk.event.UserService) ctx.getBean(org.zk.event.UserService.class);
        userService.register("zk");
        System.in.read(); // junit多线程有问题
    }


}
