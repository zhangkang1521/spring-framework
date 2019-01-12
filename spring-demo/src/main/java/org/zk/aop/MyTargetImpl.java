package org.zk.aop;

import org.springframework.aop.framework.AopContext;

/**
 * Created by Administrator on 8/23/2018.
 */
public class MyTargetImpl implements MyTarget {

    final public void sayHello() {
        System.out.println("hello");
//        throw new RuntimeException("xx");
        // ((MyTarget)AopContext.currentProxy()).sayWorld();
    }

    public void sayWorld() {
        System.out.println("sayWorld");
    }
}
