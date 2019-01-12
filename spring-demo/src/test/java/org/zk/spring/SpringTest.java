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
import org.zk.event.TestEvent;
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
        MyTarget myTarget = ctx.getBean("myTarget", MyTarget.class);
        myTarget.sayHello();
//        myTarget.sayWorld();
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

    @Test
    public void testMessage() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object[] params = {"Mary", new GregorianCalendar().getTime()};
        System.out.println(ctx.getMessage("test", params, Locale.US));
        System.out.println(ctx.getMessage("test", params, Locale.CHINA));
    }

    @Test
    public void testEvent() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.publishEvent(new TestEvent("hello", "hello,world"));
    }

    @Test
    public void testConvert() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        Date date = conversionService.convert("2018-08-19 20:54:00", Date.class);
    }


}
