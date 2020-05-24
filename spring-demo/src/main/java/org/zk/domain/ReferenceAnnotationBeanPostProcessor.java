package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.annotation.AnnotationUtils;
import org.zk.annotation.Reference;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * 简单模拟dubbo中的@Reference注解，原理同Autowired
 */
public class ReferenceAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	public PropertyValues postProcessPropertyValues(
			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		InjectionMetadata metadata = findAutowiringMetadata(beanName, bean.getClass(), pvs);
		try {
			metadata.inject(bean, beanName, pvs);
		}
		catch (Throwable ex) {
			throw new BeanCreationException(beanName, "注入Reference动态代理报错", ex);
		}
		return pvs;
	}

	private InjectionMetadata findAutowiringMetadata(String beanName, Class<?> aClass, PropertyValues pvs) {
		LinkedList<InjectionMetadata.InjectedElement> elements = new LinkedList<>();
		for (Field field : aClass.getDeclaredFields()) {
			Annotation ann = AnnotationUtils.getAnnotation(field, Reference.class);
			if (ann != null) {
				elements.add(new ReferenceFieldElement(field));
			}
		}
		return new InjectionMetadata(aClass, elements);
	}

	private class ReferenceFieldElement extends InjectionMetadata.InjectedElement {

		public ReferenceFieldElement(Field field) {
			super(field, null);
		}

		@Override
		protected void inject(Object bean, String beanName, PropertyValues pvs) throws Throwable {
			Field field = (Field)member;
			field.setAccessible(true);
			// field 必须为接口，否则报错
			field.set(bean, Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{field.getType()}, new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("代理方法 do something");
					return null;
				}
			}));
		}
	} // end of ReferenceFieldElement
}
