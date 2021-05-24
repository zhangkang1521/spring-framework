package org.zk.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * servlet3会自动执行SpringServletContainerInitializer，该类会执行WebApplicationInitializer的方法
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// 父容器
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// spring-mvc配置
		return new Class[]{SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
