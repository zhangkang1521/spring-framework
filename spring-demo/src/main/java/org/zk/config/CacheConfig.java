package org.zk.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zk.service.CacheDemoService;
import org.zk.service.impl.CacheDemoServiceImpl;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("my-user")));
		return cacheManager;
	}


	@Bean
	public CacheDemoService userService() {
		return new CacheDemoServiceImpl();
	}

}
