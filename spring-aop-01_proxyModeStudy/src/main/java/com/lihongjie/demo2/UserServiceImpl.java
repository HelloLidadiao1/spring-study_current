package com.lihongjie.demo2;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("执行新增操作。");
    }

    @Override
    public void delete() {
        System.out.println("执行删除操作。");
    }

    @Override
    public void update() {
        System.out.println("执行更新操作。");
    }

    @Override
    public void query() {
        System.out.println("执行查询操作。");
    }
}
