package org.zk.core;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.zk.config.FooConfig;

public class MyImportSelector implements ImportSelector {

	// @Import会调用该方法
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { FooConfig.class.getName() };
	}
}
