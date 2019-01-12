package org.zk.tech;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 8/3/2018.
 */
public class SystemTest {

    @Test
    public void test() {
        //
        Properties sysProperties = System.getProperties();
        System.out.println(sysProperties);
        // 环境变量
        Map env = System.getenv();
        System.out.println(env);
    }
}
