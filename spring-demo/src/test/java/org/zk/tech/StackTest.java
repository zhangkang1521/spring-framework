package org.zk.tech;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 5/22/2018.
 */
public class StackTest {

    @Test
    public void testStack() {
        // java stack 设计缺陷
        Stack<String> stack = new Stack<>();
        stack.add("a");
        stack.add("a");
        stack.add("a");
        stack.add(2, "b");
        System.out.println(stack);
    }


}
