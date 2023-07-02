package org.zk.cache;

import org.zk.domain.User;

import java.util.List;

public interface CacheDemoService {

	User findById(Integer id);

	User updateById(User user);

	void deleteById(Integer id);
}
