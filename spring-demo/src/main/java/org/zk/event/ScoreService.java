package org.zk.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 8/19/2018.
 */
public class ScoreService implements ApplicationListener<UserRegisterEvent> {

    public static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

    // 只对UserRegisterEvent感兴趣
    public void onApplicationEvent(UserRegisterEvent event) {
        logger.debug("{}增加积分", event.getSource());
    }
}
