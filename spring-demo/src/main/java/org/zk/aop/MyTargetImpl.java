package org.zk.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;

/**
 * Created by Administrator on 8/23/2018.
 */
public class MyTargetImpl implements MyTarget {

    public MyTargetImpl() {
    }

//    @Async("taskExecutor")
    @DynamicDataSource
    public void sayHello() {
        System.out.println(Thread.currentThread() + " hello");
        ((MyTarget) AopContext.currentProxy()).sayWorld();
//        this.sayWorld();
//        throw new RuntimeException("xx");
        // ((MyTarget)AopContext.currentProxy()).sayWorld();
    }

    @Override
    @DynamicDataSource
    public void sayWorld() {
        System.out.println(Thread.currentThread() + " world");
    }


}
