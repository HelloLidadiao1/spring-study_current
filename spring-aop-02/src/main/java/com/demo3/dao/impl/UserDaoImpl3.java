package com.demo3.dao.impl;

import com.demo3.dao.UserDao3;
import org.springframework.stereotype.Component;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
@Component
public class UserDaoImpl3 implements UserDao3 {
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
