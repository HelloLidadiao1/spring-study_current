package com.lihongjie.demo2;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        ProxyService proxyService = new ProxyService();
        proxyService.setUserService(userService);
        proxyService.delete();
        proxyService.add();
        proxyService.update();
        proxyService.query();
    }
}
