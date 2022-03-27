package com.lihongjie.demo.mapper;

import com.lihongjie.demo.pojo.User;

import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/24
 */
public interface UserMapper {
    /**
     * 查询用户
     * @return
     */
    public List<User> selUser();

    /**
     * 更新用户
     * @return
     */
    public Integer delUser(Integer uid);

    /**
     * 插入用户
     * @return
     */
    public Integer insUser(List<User> users);
}
