package org.zk.tech;

import org.junit.Test;
import org.zk.aop.MyTarget;
import org.zk.aop.MyTargetImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangkang
 * @date 2023/6/26 14:01
 */
public class JdkDynamicTest {

    @Test
    public void test() {
        MyTarget target = new MyTargetImpl();
        MyTarget proxy = (MyTarget) new JdkDynamicProxy(target).getProxy();
        proxy.sayHello();
    }

    static class JdkDynamicProxy implements InvocationHandler {

        private MyTarget target;

        public JdkDynamicProxy(MyTarget target) {
            this.target = target;
        }

        public Object getProxy() {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{MyTarget.class}, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("==== jdk proxy before ====");
            return method.invoke(target, args);
        }
    }
}
