package org.zk.aop;

/**
 * Created by Administrator on 8/23/2018.
 */
public class MyTargetImpl implements MyTarget {

    public MyTargetImpl() {
    }

//    @Async("taskExecutor")
//    @DynamicDataSource
    public void sayHello() {
        System.out.println(Thread.currentThread() + " hello");
//        throw new RuntimeException("xx");
        // ((MyTarget)AopContext.currentProxy()).sayWorld();
    }


}
