package org.zk.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User {
    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
