package org.zk.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.dynamicdatasource.DynamicDataSourceConfig;
import org.zk.dynamicdatasource.DynamicDataSourceDemoService;

/**
 * @author zhangkang
 * @date 2023/7/6 10:13
 */
public class DynamicDataSourceTest {

    @Test
    public void master() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DynamicDataSourceConfig.class);
        DynamicDataSourceDemoService demoService = ctx.getBean(DynamicDataSourceDemoService.class);
        demoService.save();
    }

    @Test
    public void slave() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DynamicDataSourceConfig.class);
        DynamicDataSourceDemoService demoService = ctx.getBean(DynamicDataSourceDemoService.class);
        demoService.query();
    }
}
