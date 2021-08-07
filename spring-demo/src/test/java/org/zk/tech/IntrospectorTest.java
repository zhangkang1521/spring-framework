package org.zk.tech;

import org.junit.Test;
import org.zk.domain.User;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * java内省
 */
public class IntrospectorTest {

	@Test
	public void test1() throws Exception {
		// spring使用内省获取get/set方法，然后使用反射调用
		User user = new User();
		BeanInfo beanInfo = Introspector.getBeanInfo(org.zk.domain.User.class);
		for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
			if ("id".equals(propertyDescriptor.getName())) {
				Method writeMethod = propertyDescriptor.getWriteMethod();
				writeMethod.invoke(user, 10);
			}
		}
		System.out.println(user.getId());
	}

	@Test
	public void test2() throws Exception {
		// spring-boot 配置spring.beaninfo.ignore为true
		BeanInfo beanInfo = Introspector.getBeanInfo(Child.class);
		BeanInfo beanInfo2 = Introspector.getBeanInfo(Child.class, Introspector.IGNORE_ALL_BEANINFO);
		System.out.println(beanInfo);
	}


}
