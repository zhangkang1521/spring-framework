package org.zk.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zk.domain.User;
import org.zk.service.CacheDemoService;

import java.util.ArrayList;
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

	@Override
	@Cacheable(value = "my-user", key = "#p0")
	public List<User> findByIdIn(List<Integer> userIds) {
		System.out.println("findByUserIdIn" + userIds);
		return Arrays.asList(new User(), new User());
	}

	@CachePut(value = "my-user", key = "#user.id")
	public User updateById(User user) {
		System.out.println("updateById " + user.getId());
		return user;
	}

	@CacheEvict(value = "my-user")
	public void deleteById(Integer id) {
		System.out.println("delete");
	}

	@CacheEvict(value = "my-user", allEntries = true)
	public void deleteAll() {

	}


}
