package org.zk.domain;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User {
    private int id;
    private String username;

    public User() {

    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
