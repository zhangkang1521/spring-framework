package org.zk.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User {
    private int id;

    private String username;
    private int age;
    private List<String> interests;
    private Integer[] arr;

    private Car car;

    public User() {
        System.out.println("User()");
    }

    public User(int age, Car car, List<String> interests) {
        this.age = age;
        this.car = car;
        this.interests = interests;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(int id, int age, String username) {
        this.id = id;
        this.age = age;
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

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
