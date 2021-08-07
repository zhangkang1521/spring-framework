package org.zk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.zk.web.DemoInterceptor;

/**
 * 替代spring-mvc.xml配置
 */
//@Configuration
//@EnableWebMvc
//@ComponentScan("org.zk.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/view/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	// 创建RequestMappingHandlerMapping时会调用
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**");
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("hello").setViewName("hello");
//	}

	// 静态资源访问，注入SimpleUrlHandlerMapping，将mapping映射到ResourceHttpRequestHandler
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:");
	}

	// 注入SimpleUrlHandlerMapping，将/**映射到DefaultServletHttpRequestHandler，其中使用defaultServlet进行静态资源访问
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}

}
