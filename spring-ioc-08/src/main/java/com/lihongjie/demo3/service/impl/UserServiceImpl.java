package com.lihongjie.demo3.service.impl;

import com.lihongjie.demo3.dao.UserDao;
import com.lihongjie.demo3.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
//若没有指定名字，则默认为首字母小写类名，此例为：userServiceImpl
@Service
public class UserServiceImpl implements UserService {

    // 先根据名称，再根据类型注入
    @Resource
    private UserDao userDao;

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
