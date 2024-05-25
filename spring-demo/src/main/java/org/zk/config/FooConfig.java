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
 * 被@Import导入
 * 被@Configuration注解 或者 至少需要有一个@Bean方法，否则报错
 * FooConfig即使没有被@Configuration注解，也会成为一个bean
 * 如果FooConfig没加注解@Configuration，外部调用@Bean注解的方法会重新生成bean，bean不是单例的
 */
@Configuration
public class FooConfig /*implements ImportAware*/ {

	@Bean(name = "fooUser")
	public User user() {
		User user =  new User();
		user.setUsername("zk2");
		return user;
	}

//	@Override
//	public void setImportMetadata(AnnotationMetadata importMetadata) {
//		// 获取注解属性
//		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
//				importMetadata.getAnnotationAttributes(Import.class.getName(), false));
//		System.out.println(annotationAttributes);
//	}
}
