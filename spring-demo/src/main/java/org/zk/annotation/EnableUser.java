package org.zk.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyRegister.class) // 导入配置
public @interface EnableUser {
}
