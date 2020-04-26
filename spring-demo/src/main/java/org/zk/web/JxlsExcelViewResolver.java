package org.zk.web;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * jxls excel视图解析
 */
public class JxlsExcelViewResolver extends AbstractTemplateViewResolver {

	public JxlsExcelViewResolver() {
		setViewClass(requiredViewClass());
	}


	@Override
	protected Class<?> requiredViewClass() {
		return JxlsExcelView.class;
	}
}
