package com.lihongjie.demo.service.impl;

import com.lihongjie.demo.exception.MyException;
import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.pojo.User;
import com.lihongjie.demo.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/25
 */
// 注解在类上，会给该类的所有方法加上事务管理【不论是否是从接口继承实现过来的，只有public修饰的方法有效果，非私有的加上了也不会生效】
//@Transactional
public class UserServiceImplByAnno implements UserService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //@Transactional
    @Override
    public void opeUser(boolean flag) {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        //在没有事务的情况下，即使delUser报错了，但是插入用户仍然成功了，这是一个完整的业务，只完成一部分显然不符合要求
        //所以这一整套逻辑需要在事务下运行，要么都成功，要么都失败。
        userMapper.delUser(15);
        userMapper.selUser();
    }

    /*
    * 测试@Transactional 对于非public方法，是否能进行事务管理
    * 经测试@Transactional，加在非公有方法上虽然不会报错，但是也并不生效
    */
    //@Transactional
    private void opeUserPrivate(){
        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        //在没有事务的情况下，即使delUser报错了，但是插入用户仍然成功了，这是一个完整的业务，只完成一部分显然不符合要求
        //所以这一整套逻辑需要在事务下运行，要么都成功，要么都失败。
        userMapper.delUser(15);
        userMapper.selUser();
    }

    public void callOpeUserPrivate(){
        this.opeUserPrivate();
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    //测试事务的传播机制A_实现新增用户，并且调用B进行删除
    public void propagationTestA() throws MyException {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        propagationTestB();
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    //测试事务的传播机制A_实现删除用户
    public void propagationTestB() throws MyException {
        List<User> users = new ArrayList<>();
        users.add(new User(16, "test_transaction16", "lihongjie@qq.com"));
        userMapper.insUser(users);
        if(userMapper.selUser().size() > 0){
            throw new RuntimeException("测试传播机制报错");
        }
        userMapper.delUser(15);
        //throw new MyException("测试事务的传播机制.....");
    }
}
