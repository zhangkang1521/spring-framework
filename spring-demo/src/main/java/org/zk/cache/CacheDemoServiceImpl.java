package org.zk.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zk.domain.User;

import java.util.Arrays;
import java.util.List;

@Service
public class CacheDemoServiceImpl implements CacheDemoService {

	@Cacheable("my-user")
	public User findById(Integer id) {
		System.out.println("findById " + id);
		User user = new User();
		user.setId(id);
		user.setUsername("zk" + id);
		return user;
	}

	@CacheEvict(value = "my-user", beforeInvocation = true)
	public void deleteById(Integer id) {
		System.out.println("delete");
	}

	@CachePut(value = "my-user", key = "#user.id")
	public User updateById(User user) {
		System.out.println("updateById " + user.getId());
		return user;
	}
}
