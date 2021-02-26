package org.zk.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User implements Serializable {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Order order;

    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Min(value = 18, message = "年龄不能小于18岁")
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
