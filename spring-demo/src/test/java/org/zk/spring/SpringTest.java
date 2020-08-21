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
import org.zk.aop.MyTarget;
import org.zk.convert.String2DateConverter;
import org.zk.domain.User;
import org.zk.event.UserRegisterEvent;
import org.zk.service.SayHelloService;
import org.zk.service.UserService;

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
        User user = (User)ctx.getBean("user");
        System.out.println(user.getUsername());
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
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }

    @Test
    public void testMessage() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object[] params = {"Mary", new GregorianCalendar().getTime()};
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

    @Test
    public void testConvert() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        Date date = conversionService.convert("2018-08-19 20:54:00", Date.class);
    }


}
