package org.zk.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zk.dao.UserDao;
import org.zk.domain.User;
import org.zk.service.UserService;

//@Service
//@Profile("prod")
public class UserServiceImpl2 implements UserService {

	private UserDao userDao;

	public UserServiceImpl2() {
	}

	@Override
	public User getNewUser() {
		User user = new User();
		user.setId(2);
		return user;
	}

	@Override
	@Transactional
	public void update() {
		userDao.update(1, "yyy");
		throw new RuntimeException("xx");
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
