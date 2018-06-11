package org.zk.domain;

import java.util.List;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User {
    private int id;

    private String username;
    private List<String> interests;


    private Car car;

    public User() {
        System.out.println("User()");
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public void sayHello() {
        System.out.println(Thread.currentThread());
    }

    public void sayHello2() {
        System.out.println(Thread.currentThread());
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

}
