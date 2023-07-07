package org.zk.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangkang
 * @date 2023/7/6 13:07
 */
@Component
public class AsyncDemoService {

    public static final Logger log = LoggerFactory.getLogger(AsyncDemoService.class);

    @Async
    public void sayHello(int i) {
        log.info("=== sayHello start ===" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("=== sayHello end === " + i);
    }

    public Future<String> testFuture(String str) {
        return new AsyncResult("hello" + str);
    }
}
