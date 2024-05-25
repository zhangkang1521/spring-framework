package org.zk.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.zk.config.FooConfig;

/**
 * TransactionManagementConfigurationSelector 会根据注解配置选择spring动态代理或ASPECTJ静态大力
 * spring-boot的AutoConfigurationImportSelector 扫描所有spring.factories查找自动配置类
 */
public class MyImportSelector implements ImportSelector {

	// @Import会调用该方法
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { FooConfig.class.getName() };
	}
}
