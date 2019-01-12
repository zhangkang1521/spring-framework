package org.zk.domain;

import java.util.Date;

/**
 * Created by Administrator on 6/5/2018.
 */
public class Car {
    private String brand;
    private Long speed;
    private User user;
    private Date createTime;

    public Car() {
        System.out.println("Car()");
    }

    public Car(User user) {
        this.user = user;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
