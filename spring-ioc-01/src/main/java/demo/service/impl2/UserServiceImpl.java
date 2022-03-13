package demo.service.impl2;

import demo.dao.UserDao;
import demo.dao.impl.UserDaoMysqlImpl;
import demo.service.UserService;

/**
 * @author lihongjie
 * @date 2022/2/13
 */
public class UserServiceImpl implements UserService {

    /**
     * 此处和impl1相比有本质的差别，程序员不再手动去创建userDao的实现，
     * 而是通过提供setUserDao方法，把控制权给甩出去，由调用者来决定究竟用哪个实现。
     * 参见test.java.TestDemo2
     * （用到的技术：多态  思想：面向接口开发，控制反转）
     */
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
