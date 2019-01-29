package org.zk.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 8/23/2018.
 */
//@Aspect
public class MyAspect2 {

    @Before("execution(public * xx())")
    public void before() {
        System.out.println("=== before ===");
    }
}
