package org.zk.dao;

import org.apache.ibatis.annotations.Param;
import org.zk.domain.User;

public interface UserDao {

	User findById(int id);

	void update(@Param("id") int id, @Param("username") String username);
}
