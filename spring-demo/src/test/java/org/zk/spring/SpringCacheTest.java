package org.zk.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.config.CacheConfig;
import org.zk.domain.User;
import org.zk.service.CacheDemoService;

import java.util.Arrays;
import java.util.List;

public class SpringCacheTest {

	AnnotationConfigApplicationContext ctx ;
	CacheDemoService cacheDemoService;
	CacheManager cacheManager;


	@Before
	public void before() {
		ctx = new AnnotationConfigApplicationContext(CacheConfig.class);
		cacheDemoService = ctx.getBean(CacheDemoService.class);
		cacheManager = ctx.getBean(CacheManager.class);
	}


	@Test
	public void cacheAble() {
		cacheDemoService.findById(1);
		cacheDemoService.findById(1);
		cacheDemoService.findById(2);
	}

	@Test
	public void cacheList() {
		List<User> list1 = cacheDemoService.findByIdIn(Arrays.asList(1, 2));
		User user = new User();
		user.setId(1);
//		cacheDemoService.updateById(user);
		List<User> list2 = cacheDemoService.findByIdIn(Arrays.asList(1, 2));
	}

	@Test
	public void cachePut() {
		User user = cacheDemoService.findById(1);
		User userUpdate = new User();
		userUpdate.setId(1);
		userUpdate.setUsername("xxx");
		cacheDemoService.updateById(userUpdate);
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
