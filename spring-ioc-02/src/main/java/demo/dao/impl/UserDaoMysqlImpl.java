package demo.dao.impl;

import demo.dao.UserDao;

/**
 * @author lihongjie
 * @date 2022/2/13
 */
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql调用用户业务逻辑");
    }
}
