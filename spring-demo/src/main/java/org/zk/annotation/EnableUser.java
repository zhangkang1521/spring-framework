package org.zk.annotation;

import org.springframework.context.annotation.Import;
import org.zk.config.MyImportBeanDefinitionRegistrar;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinitionRegistrar.class) // 导入配置
public @interface EnableUser {
}
