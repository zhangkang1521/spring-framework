package org.zk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 8/23/2018.
 */
@Aspect
@Component
public class MyAspect {

    public static final Logger log = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(public * org.zk.aop.MyTargetImpl.sayHello())")
    public void pointCut1() {

    }

    @Before("pointCut1()")
    public void before() {
        log.info("=== before ===");
    }


}
