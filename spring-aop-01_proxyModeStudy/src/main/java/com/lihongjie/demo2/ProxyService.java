package com.lihongjie.demo2;

/**
 * @author lihongjie
 * @date 2022/3/17
 */

/**
 * UserService的代理类，本demo的代理的作用是，userService中执行方法执行打印日志
 */
public class ProxyService implements UserService{
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("methodName");
        userService.query();
    }

    public void log(String methodName){
        System.out.println("[Debug] 进入" + methodName + "方法....");
    }
}
