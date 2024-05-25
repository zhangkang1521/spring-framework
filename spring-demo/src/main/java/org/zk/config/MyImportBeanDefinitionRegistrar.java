package org.zk.config;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.zk.annotation.EnableUser;
import org.zk.domain.User;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

/**
 * @EnableAspectJAutoProxy 注册代理创建器
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	// @Import会自动调用
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableUser.class.getName());
		// 自动注入bean
		BeanDefinitionBuilder builder = rootBeanDefinition(User.class);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
		registry.registerBeanDefinition("user10", beanDefinition);
	}
}
