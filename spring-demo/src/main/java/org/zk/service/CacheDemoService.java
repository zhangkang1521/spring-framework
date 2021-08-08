package org.zk.service;

import org.zk.domain.User;

public interface CacheDemoService {

	User findById(Integer id);

	User updateById(User user);

	void deleteById(Integer id);

	void deleteAll();
}
