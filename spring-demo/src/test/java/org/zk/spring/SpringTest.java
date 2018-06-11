package org.zk.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.zk.domain.User;
import org.zk.service.PayService;
import org.zk.service.SayHelloService;
import org.zk.service.UserService;
import org.zk.service.bank.BankService;
import org.zk.service.bank.CcbService;


/**
 * Created by Administrator on 5/22/2018.
 */
public class SpringTest {

    @Test
    public void testClassPathCtx() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ctx.getBean("user", User.class);
//        user.sayHello(null);
//        System.out.println(user);
    }



    public static void main(String[] args) throws Exception{
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ctx.getBean("user", User.class);
        for (int i = 0; i < 1; i++) {
            user.sayHello();
            user.sayHello2();
        }

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
