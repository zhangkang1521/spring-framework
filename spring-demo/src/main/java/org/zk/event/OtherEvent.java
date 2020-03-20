package org.zk.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 8/19/2018.
 */
public class OtherEvent extends ApplicationEvent {


    public OtherEvent(String name) {
        super(name);
    }


}
