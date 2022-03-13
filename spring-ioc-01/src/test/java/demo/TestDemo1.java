package demo;

import demo.service.UserService;
import demo.service.impl3.UserServiceImpl;

/**
 * @author lihongjie
 * @date 2022/2/13
 * TestDemo1 在此扮演的角色为调用者/用户
 */
public class TestDemo1 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
