package org.zk;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.zk.domain.User;

/**
 * Created by Administrator on 5/20/2018.
 */
public class SpringDemo {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("E:/applicationContext.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println(user);
    }
}
