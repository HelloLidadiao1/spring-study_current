package com.lihongjie.demo.mapper;

import com.lihongjie.demo.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/22
 */
public class UserMapperImpl implements UserMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper userMapper = this.getUserMapper();
        return userMapper.selectUser();
    }

    /*@Override
    public Integer updUsers(List<User> users) {
        UserMapper userMapper = this.getUserMapper();
        for (User user : users) {
            userMapper.updUser(user);
        }
        return 1;
    }

    @Override
    public Integer updUser(User users) {
        return null;
    }*/


    private UserMapper getUserMapper(){
        return sqlSession.getMapper(UserMapper.class);
    }
}
