package com.lihongjie.demo.mapper2;

import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/22
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper2 {
    
    @Override
    public List<User> selectUser() {
        SqlSession sqlSession = this.getSqlSession();
        UserMapper2 userMapper2 = sqlSession.getMapper(UserMapper2.class);
        return userMapper2.selectUser();
    }
}
