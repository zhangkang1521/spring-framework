package org.zk.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 8/19/2018.
 */
public class TestEvent extends ApplicationEvent {

    private String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print() {
        System.out.println(msg);
    }
}
