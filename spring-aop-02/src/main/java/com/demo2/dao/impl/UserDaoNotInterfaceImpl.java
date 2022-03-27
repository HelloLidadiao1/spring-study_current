package com.demo2.dao.impl;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
public class UserDaoNotInterfaceImpl {
    public String add(String user) {
        System.out.println("新增了一个用户：" + user);
        return user;
    }

    public void delete(String user) {
        System.out.println("删除了一个用户：" + user);
    }

    public void update(String oldUser, String newUser) {
        System.out.println("修改了一个用户：" + oldUser + "---->" + newUser);
    }

    public void query() {
        System.out.println("查询了一个用户：");
        throw new RuntimeException("异常通知抛出异常");
    }
}
