package org.zk.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.zk.annotation.Reference;
import org.zk.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Administrator on 5/20/2018.
 */
//@XmlRootElement
public class User implements InitializingBean , ApplicationContextAware {
    private Integer id;

    @Value("${jdbc.username}")
    private String username;

    private int age;
//    private List<String> interests;
    private Integer[] arr;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Reference
    private UserService userService;

    @Autowired
    private Car car;


    public User() {
        System.out.println("调用构造方法User()");
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

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用setApplicationContext");
    }
}
