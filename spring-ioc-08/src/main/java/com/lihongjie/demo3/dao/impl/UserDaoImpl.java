package com.lihongjie.demo3.dao.impl;

import com.lihongjie.demo3.dao.UserDao;
import com.lihongjie.demo3.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private User user;

    @Override
    public void getUser() {
        System.out.println(user);
    }
}
