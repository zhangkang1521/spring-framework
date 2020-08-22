package org.zk.core;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.zk.domain.User;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	// @Import会自动调用
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 自动注入bean
		BeanDefinitionBuilder builder = rootBeanDefinition(User.class);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
		registry.registerBeanDefinition("user10", beanDefinition);
	}
}
