package com.cm.DynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by chengangw on 2019/3/1.
 */
public class CglibProxyTest implements MethodInterceptor {
    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib proxy start ...");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib proxy end ...");
        return null;
    }

    public Object gerCglibProxy(Object targetObj) {
        this.target = targetObj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObj.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

    public static void main(String[] args) {
        CglibProxyTest cglibProxyTest = new CglibProxyTest();
        UserManager userManager = (UserManager) cglibProxyTest.gerCglibProxy(new UserManagerImpl());
        userManager.deleterUser("admin");

    }
}
