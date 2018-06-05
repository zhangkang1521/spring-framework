package org.zk.service;

import org.zk.domain.User;

/**
 * Created by Administrator on 6/5/2018.
 */
public class UserFactory {

    public static User getUser() {
        return new User();
    }
}
