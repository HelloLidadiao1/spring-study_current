package com.lihongjie.demo.dao.impl;

import com.lihongjie.demo.dao.UserDao;
import com.lihongjie.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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
