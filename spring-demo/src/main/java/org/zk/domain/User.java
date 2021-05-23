package org.zk.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Administrator on 5/20/2018.
 */
public class User implements Serializable {


    private Integer id;

//    @NotBlank(message = "用户名不能为空")
    @Value("${M2_HOME}")
    private String username;

//    @Autowired
    private Order order;


    public User() {
        System.out.println("invoke user()");
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

}
