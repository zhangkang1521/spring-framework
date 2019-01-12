package org.zk.domain;

import org.springframework.context.ApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User {
    private Integer id;

    private String username;
    private int age;
//    private List<String> interests;
    private Integer[] arr;
    private Date birthday;

    private Car car;
    Class clzz;

    private ApplicationContext ctx;

    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public User() {
        System.out.println("User()");
    }


//    @ConstructorProperties({"id", "username"})
    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

//    @ConstructorProperties({"id", "username", "age"})
    public User(Integer id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }


    public void sayHello() {
        System.out.println(Thread.currentThread());
    }

    public void sayHello2() {
        System.out.println(Thread.currentThread());
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

//    public List<String> getInterests() {
//        return interests;
//    }
//
//    public void setInterests(List<String> interests) {
//        this.interests = interests;
//    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Class getClzz() {
        return clzz;
    }

    public void setClzz(Class clzz) {
        this.clzz = clzz;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
