package org.zk.annotation;

import java.lang.annotation.*;

/**
 * 简单dubbo的@Reference注解
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Reference {
}
