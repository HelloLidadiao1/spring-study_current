package com.lihongjie.demo.service.impl;

import com.lihongjie.demo.exception.MyException;
import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.pojo.User;
import com.lihongjie.demo.service.UserService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/25
 */
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void opeUser(boolean flag) throws MyException {
        /*System.out.println(userMapper instanceof UserMapper);
        System.out.println(userMapper.getClass().getGenericSuperclass());
        Type[] genericInterfaces = userMapper.getClass().getGenericInterfaces();
        userMapper.getClass().getInterfaces();*/

        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        //在没有事务的情况下，即使delUser报错了，但是插入用户仍然成功了，这是一个完整的业务，只完成一部分显然不符合要求
        if(flag){
            throw new MyException("测试事务回滚，李洪杰自定义异常.....");
        }
        userMapper.delUser(15);
        userMapper.selUser();
    }

    //测试事务的传播机制A_实现新增用户，并且调用B进行删除
    public void propagationTestA() throws MyException {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        propagationTestB();
    }

    //测试事务的传播机制A_实现删除用户
    public void propagationTestB() throws MyException {
        userMapper.delUser(15);
        if(userMapper.selUser().size() > 0){
            throw new RuntimeException("测试传播机制报错");
        }
        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        //throw new MyException("测试事务的传播机制.....");
    }
}
