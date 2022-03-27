package com.lihongjie.demo.service;

import com.lihongjie.demo.exception.MyException;

/**
 * @author lihongjie
 * @date 2022/3/25
 */
public interface UserService {
    public void opeUser(boolean flag) throws MyException;
}
