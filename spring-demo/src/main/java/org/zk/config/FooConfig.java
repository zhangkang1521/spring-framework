package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.EnableAsync;
import org.zk.domain.User;

/**
 * 类有@Configuration注解或至少1个@Bean注解的方法
 */
@Configuration
public class FooConfig /*implements ImportAware*/ {

//	@Bean(name = "fooUser")
//	public User user() {
//		User user =  new User();
//		user.setUsername("zk2");
//		return user;
//	}

//	@Override
//	public void setImportMetadata(AnnotationMetadata importMetadata) {
//		// 获取注解属性
//		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
//				importMetadata.getAnnotationAttributes(Import.class.getName(), false));
//		System.out.println(annotationAttributes);
//	}
}
