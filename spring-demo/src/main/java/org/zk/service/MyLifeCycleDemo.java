package org.zk.service;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @author zhangkang
 * @date 2024/6/22 20:21
 */
//@Component
public class MyLifeCycleDemo implements Lifecycle {

    private volatile boolean running = false;

    /**
     * 需要调用容器的start方法才会调用
     */
    @Override
    public void start() {
        System.out.println("start");
        running = true;
    }

    /**
     * 需要调用容器的stop方法才会调用
     */
    @Override
    public void stop() {
        System.out.println("stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
