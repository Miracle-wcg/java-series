package com.cm.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chengangw on 2019/3/1.
 */
public class JdkProxyTest implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK dynamic proxy start ...");
        Object result = method.invoke(target, args);
        System.out.println("JDK dynamic proxy end ...");
        return null;
    }

    private Object gerJdkProxy(Object targetObject) {
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        JdkProxyTest jdkProxyTest = new JdkProxyTest();
        UserManager userManager = (UserManager) jdkProxyTest.gerJdkProxy(new UserManagerImpl());
        userManager.addUser("admin", "123456");
    }
}
