package com.lihongjie.demo.mapper;

import com.lihongjie.demo.pojo.User;

import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/21
 */
public interface UserMapper {
    public List<User> selectUser();

    /*public Integer updUsers(List<User> users);

    public Integer updUser(User users);*/

}