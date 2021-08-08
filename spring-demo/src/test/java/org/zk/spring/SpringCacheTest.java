package org.zk.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.CacheConfig;
import org.zk.domain.User;
import org.zk.service.CacheDemoService;

public class SpringCacheTest {

	AnnotationConfigApplicationContext ctx ;
	CacheDemoService cacheDemoService;

	@Before
	public void before() {
		ctx = new AnnotationConfigApplicationContext(CacheConfig.class);
		cacheDemoService = ctx.getBean(CacheDemoService.class);
	}


	@Test
	public void cacheAble() {
		cacheDemoService.findById(1);
		cacheDemoService.findById(1);
		cacheDemoService.findById(2);
	}

	@Test
	public void cachePut() {
		User user = cacheDemoService.findById(1);
		user.setUsername("xx");
		cacheDemoService.updateById(user);
		// 不会执行实际方法，但获取的是最新的数据
		User user2 = cacheDemoService.findById(1);
	}

	@Test
	public void cacheEvict() {
		cacheDemoService.findById(1);
		cacheDemoService.findById(2);
		cacheDemoService.deleteById(1);
		cacheDemoService.findById(1); // 会执行实际方法
		cacheDemoService.findById(2); // 走缓存
	}

	@Test
	public void cacheEvictAll() {
		cacheDemoService.findById(1);
		cacheDemoService.findById(2);
		cacheDemoService.deleteAll();
		// 都会执行实际方法
		cacheDemoService.findById(1);
		cacheDemoService.findById(2);
	}
}
