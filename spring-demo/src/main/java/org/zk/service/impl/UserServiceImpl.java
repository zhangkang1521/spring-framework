package org.zk.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zk.dao.UserDao;
import org.zk.domain.User;
import org.zk.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public User getNewUser() {
		return null;
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
