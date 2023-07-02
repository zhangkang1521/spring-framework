package org.zk.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zk.cache.CacheConfig;
import org.zk.cache.CacheDemoService;
import org.zk.domain.User;

import java.util.Arrays;
import java.util.List;

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
	}

	@Test
	public void cacheEvict() {
		//cacheDemoService.findById(1);
		cacheDemoService.deleteById(1);
		//cacheDemoService.findById(1);
	}

	@Test
	public void cachePut() {
		User userUpdate = new User();
		userUpdate.setId(1);
		userUpdate.setUsername("xxx");
		cacheDemoService.updateById(userUpdate);
	}

}
