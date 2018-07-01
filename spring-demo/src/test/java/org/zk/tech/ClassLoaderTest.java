package org.zk.tech;

import java.io.InputStream;

/**
 * Created by Administrator on 6/22/2018.
 */
public class ClassLoaderTest {

    public void test1() {
        // ClassPathResource 实现原理
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream("applicationContext.xml");
    }

    public void test2() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("applicationContext.xml");
    }
}
