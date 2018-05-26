package org.zk.service;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 5/26/2018.
 */
public class SayHelloReplace implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("wow! hello is changed!");
        return null;
    }
}
