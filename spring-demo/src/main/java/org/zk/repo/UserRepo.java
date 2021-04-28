package org.zk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zk.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	UserEntity findTopByUsername(String username);
}
