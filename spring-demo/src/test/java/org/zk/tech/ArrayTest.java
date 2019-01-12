package org.zk.tech;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

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

    @Test
    public void test2() {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == 1);
        System.out.println(a == b);
        System.out.println(Objects.equals(a , b));
    }
}
