package org.zk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Administrator on 8/23/2018.
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(public * org.zk.aop.MyTargetImpl.say*())")
    public void pointCut1() {

    }

    @Before("execution(public * org.zk.aop.MyTargetImpl.say*())")
//    @Before("pointCut1()")
    public void before() {
        System.out.println("=== before ===");
    }

    @After("pointCut1()")
    public void after() {
        System.out.println("=== after ===");
    }
//
//    @Around("pointCut1()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("=== around before ===");
//        try {
//            pjp.proceed();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("=== around after ===");
//    }

//    @AfterReturning("pointCut1()")
//    public void afterReturn() {
//        System.out.println("=== afterReturn ===");
//    }

//    @AfterThrowing("pointCut1()")
//    public void afterThrowing() {
//        System.out.println("=== afterThrowing ===");
//    }

}
