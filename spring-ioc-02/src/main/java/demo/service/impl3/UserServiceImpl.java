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
     * 组合
     */
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        System.out.println("Log_UserServiceImpl 执行set方法对userDao进行赋值.....");
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        this.userDao.getUser();
    }
}
