package demo;

import demo.dao.impl.UserDaoMysqlImpl;
import demo.dao.impl.UserDaoOracleImpl;
import demo.service.UserService;
import demo.service.impl2.UserServiceImpl;

/**
 * @author lihongjie
 * @date 2022/2/13
 * TestDemo2 在此扮演的角色为调用者/用户
 */
public class TestDemo2 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //当调用者的需求发生变化时，只需要调用者自己更改需要用哪个实现即可，程序员不再需要跟着改代码了
        ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
        ((UserServiceImpl)userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
