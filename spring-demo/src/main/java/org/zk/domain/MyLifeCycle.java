package org.zk.domain;

import org.springframework.context.Lifecycle;

/**
 * Created by Administrator on 8/19/2018.
 */
public class MyLifeCycle implements Lifecycle {
    @Override
    public void start() {
        System.out.println("=== start ===");
    }

    @Override
    public void stop() {
        System.out.println("=== stop ===");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
