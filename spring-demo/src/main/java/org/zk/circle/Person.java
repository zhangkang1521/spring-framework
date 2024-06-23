package org.zk.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangkang
 * @date 2024/6/23 13:04
 */
@Component
public class Person {

    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
