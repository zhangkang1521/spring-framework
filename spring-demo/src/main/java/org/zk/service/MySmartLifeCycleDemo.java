package org.zk.service;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 解决必须要调用容器的start,stop方法才会调用start,stop方法
 * @author zhangkang
 * @date 2024/6/22 20:21
 */
//@Component
public class MySmartLifeCycleDemo implements SmartLifecycle {

    private volatile boolean running = false;


    @Override
    public void start() {
        System.out.println("start");
        running = true;
    }


    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        System.out.println("isRunning:" + running);
        return running;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        this.running = false;
        callback.run();
    }
}
