package com.demo3.dao.impl;

import org.springframework.stereotype.Component;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
@Component
public /*final*/ class UserDaoNotInterfaceImpl {
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
