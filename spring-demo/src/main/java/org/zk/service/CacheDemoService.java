package org.zk.service;

import org.zk.domain.User;

import java.util.List;

public interface CacheDemoService {

	User findById(Integer id);

	List<User> findByIdIn(List<Integer> userIds);

	User updateById(User user);

	void deleteById(Integer id);

	void deleteAll();
}
