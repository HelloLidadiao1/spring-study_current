package com.demo2.dao.impl;

import com.demo2.dao.UserDao2;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
public class UserDaoImpl2 implements UserDao2 {
    @Override
    public String add(String user) {
        System.out.println("新增了一个用户：" + user);
        return user;
    }

    @Override
    public void delete(String user) {
        System.out.println("删除了一个用户：" + user);
    }

    @Override
    public void update(String oldUser, String newUser) {
        System.out.println("修改了一个用户：" + oldUser + "---->" + newUser);
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户：");
        throw new RuntimeException("异常通知抛出异常");
    }
}
