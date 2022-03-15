package com.lihongjie.demo.dao.impl;

import com.lihongjie.demo.dao.UserDao;
import com.lihongjie.demo.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Repository("userDao")
public class UserDaoMysqlImpl implements UserDao {
    @Resource
    private User user;

    @Override
    public void getUser() {
        System.out.println("进入UserDaoMysqlImpl....");
        System.out.println(user);
    }
}
