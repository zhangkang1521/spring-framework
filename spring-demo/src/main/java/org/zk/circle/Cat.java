package org.zk.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangkang
 * @date 2024/6/23 13:04
 */
@Component
public class Cat {

    private Person person;

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }
}
