package org.zk.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by Administrator on 8/23/2018.
 */
public class MyTargetImpl implements MyTarget, InitializingBean {

    public MyTargetImpl() {
        System.out.println("MyTargetImpl()");
    }

//    @Async("taskExecutor")
    public void sayHello() {
        System.out.println(Thread.currentThread() + " hello");
//        throw new RuntimeException("xx");
        // ((MyTarget)AopContext.currentProxy()).sayWorld();
    }

    public void sayWorld() {
        System.out.println(Thread.currentThread() + " world");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
