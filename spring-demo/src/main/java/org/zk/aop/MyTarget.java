package org.zk.aop;

import org.springframework.scheduling.annotation.Async;

/**
 * Created by Administrator on 8/23/2018.
 */
public interface MyTarget {



    // @DynamicDataSource 实现类拿不到接口方法的注解，故切面无效
    void sayHello();

    void sayWorld();


}
