package org.zk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zk.entity.UserEntity;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	List<UserEntity> findByUsername(String username);
}
