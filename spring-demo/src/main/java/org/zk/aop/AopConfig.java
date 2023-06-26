package org.zk.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangkang
 * @date 2023/6/26 13:28
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.zk.aop")
public class AopConfig {
}
