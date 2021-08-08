package org.zk.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * servlet3会自动执行 SpringServletContainerInitializer，该类会执行WebApplicationInitializer的方法
 */
public class WebAppInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

	protected Class<?>[] getRootConfigClasses() {
		// 父容器
		return new Class[]{AppConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		// spring-mvc配置
		return new Class[]{MvcConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
