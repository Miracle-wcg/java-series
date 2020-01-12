package com.cm.DynamicProxy;

/**
 * Created by chengangw on 2019/3/1.
 */
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName:" + userName + " password:" + password);
    }

    @Override
    public void deleterUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName:" + userName);

    }
}
