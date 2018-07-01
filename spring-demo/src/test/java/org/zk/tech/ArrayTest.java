package org.zk.tech;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 6/17/2018.
 */
public class ArrayTest {

    @Test
    public void test1() {
        // 使用反射创建数组
        Object arr = Array.newInstance(Integer.class, 10);
        Array.set(arr, 2, 222);

    }
}
