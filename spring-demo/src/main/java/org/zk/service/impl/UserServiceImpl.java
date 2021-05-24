package org.zk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zk.dao.UserDao;
import org.zk.domain.User;
import org.zk.entity.UserEntity;
import org.zk.repo.UserRepo;
import org.zk.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
//@Profile("dev")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

//	@PersistenceContext
//	@Autowired
	private EntityManager entityManager;

//	@Autowired
	private UserRepo userRepo;


	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//	@Transactional
	public User find(int id) {
		return userDao.findById(1);
		// return userRepo.findTopByUsername("11");
		// return entityManager.find(UserEntity.class, id+1);
	}

	@Override
	public User getNewUser() {
		User user = new User();
		user.setId(1);
		return user;
	}

	@Override
	@Transactional
	public void update() {
		userDao.update(1, "zk2");
		userDao.update(1, "zk3");
//		 throw new RuntimeException("xxx");
	}


}
