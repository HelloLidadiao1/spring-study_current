package com.demo2.dao;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
public interface UserDao2 {
    String add(String user);

    void delete(String user);

    void update(String oldUser, String newUser);

    void query();

}
