package org.zk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 8/23/2018.
 */
@Aspect
public class MyAspect {

    public static final Logger log = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(public * org.zk.aop.MyTarget.sayH*())")
//    @Pointcut("@annotation(org.zk.aop.DynamicDataSource)")
    public void pointCut1() {

    }

    @Pointcut("execution(public * org.zk.aop.MyTarget.xxx())")
//    @Pointcut("@annotation(org.zk.aop.DynamicDataSource)")
    public void pointCut2() {

    }

    @Before("pointCut1()")
    public void before() {
        log.info("=== before ===");
    }

    @After("pointCut2()")
    public void after() {
        log.info("=== after ===");
    }

//    @Around("pointCut1()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("=== around start ===");
//        Object result = joinPoint.proceed();
//        log.info("=== around end ===");
//        return result;
//    }

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
