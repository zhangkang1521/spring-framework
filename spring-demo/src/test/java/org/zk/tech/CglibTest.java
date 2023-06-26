package org.zk.tech;

import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.springframework.cglib.core.DefaultNamingPolicy;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;
import org.springframework.cglib.proxy.*;
import org.zk.aop.MyTargetImpl;
import org.zk.domain.User;
import org.zk.service.UserService;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 6/2/2018.
 */
public class CglibTest {

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTargetImpl.class);
        enhancer.setCallbacks(new Callback[] {
                new MyMethodInterceptor(new MyTargetImpl())
        });

        MyTargetImpl proxy = (MyTargetImpl)enhancer.create();
        proxy.sayHello();
    }

    class MyMethodInterceptor implements MethodInterceptor {

        private MyTargetImpl target;

        public MyMethodInterceptor(MyTargetImpl target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("=== cglib before ===");
            return method.invoke(target, args);
        }
    }


}
