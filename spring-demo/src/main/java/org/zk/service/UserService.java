package org.zk.service;

import org.zk.domain.User;
import org.zk.entity.UserEntity;

/**
 * Created by Administrator on 5/26/2018.
 */
public interface UserService {

   User getNewUser();

   void update();

   UserEntity find(int id);
}
