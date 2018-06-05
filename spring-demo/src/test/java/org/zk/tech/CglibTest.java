package org.zk.tech;

import org.junit.Test;
import org.springframework.cglib.core.DefaultNamingPolicy;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;
import org.springframework.cglib.proxy.*;
import org.zk.domain.User;
import org.zk.service.UserService;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 6/2/2018.
 */
public class CglibTest {

    @Test
    public void testInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setNamingPolicy(new MyNamePolicy());
        enhancer.setCallbackFilter(new CallbackFilter());
        enhancer.setCallbacks(new Callback[] {
                new MyMethodInterceptor(),
                new MyMethodInterceptor2()
        });

        UserService userService = (UserService)enhancer.create();
        User user = userService.getNewUser();
        System.out.println(user);
    }

    class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("hello cglib");
            return new User();
        }
    }

    class MyMethodInterceptor2 implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("hello cglib 2");
            return new User();
        }
    }

    class CallbackFilter implements org.springframework.cglib.proxy.CallbackFilter {

        @Override
        public int accept(Method method) {
            return 1;
        }
    }

    class MyNamePolicy extends DefaultNamingPolicy {

        public String getTag() {
            return "byZk";
        }
    }


}
