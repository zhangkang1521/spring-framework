package org.zk.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	// @Import会调用该方法
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { UserConfiguration.class.getName() };
	}
}
