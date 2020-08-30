package org.zk.core;

import org.springframework.context.SmartLifecycle;

/**
 * 如果只是实现Lifecycle，必须调用ctx.start()才能触发start方法
 */
public class MyLifeCycle implements SmartLifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("=== start ===");
    }

    @Override
    public void stop() {
        System.out.println("=== stop ===");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }
}
