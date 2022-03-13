package demo.service.impl3;

import demo.dao.UserDao;
import demo.dao.impl.UserDaoMysqlImpl;
import demo.service.UserService;

/**
 * @author lihongjie
 * @date 2022/2/13
 */
public class UserServiceImpl implements UserService {

    /**
     * 此处将UserDao作为自己的属性使用，这种方式在java中叫做组合
     * 由程序员自己手动去new对象实现，有弊端，如果调用者（用户）的需求变了，
     * 假如这里需要用UserDaoMysqlImpl或者需要用到UserDaoOracleImpl的话，程序员得改动代码，
     * 弊端1：代码需要跟着调用者得需求改变而改变（耦合度太高）
     * 弊端2：如果这样得代码在很多地方被用到，工作量会很大
     */
    //private UserDao userDao = new UserDaoImpl();
    private UserDao userDao = new UserDaoMysqlImpl();
    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
