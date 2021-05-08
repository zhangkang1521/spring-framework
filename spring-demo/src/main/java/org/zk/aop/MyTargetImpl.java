package org.zk.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by Administrator on 8/23/2018.
 */
@Component
public class MyTargetImpl implements MyTarget {

    public static final Logger log = LoggerFactory.getLogger(MyTargetImpl.class);

    public MyTargetImpl() {
    }

//    @Async
//    @DynamicDataSource
    public void sayHello() {
//
        log.info("sayHello invoke");
//        System.out.println(Thread.currentThread() + " hello");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return new AsyncResult("23");
//
//        ((MyTarget) AopContext.currentProxy()).sayWorld();
//        this.sayWorld();
//        throw new RuntimeException("xx");
        // ((MyTarget)AopContext.currentProxy()).sayWorld();
    }

    @Override
//    @DynamicDataSource
    public void sayWorld() {
        System.out.println(Thread.currentThread() + " world");
    }


}
