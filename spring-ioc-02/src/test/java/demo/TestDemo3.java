package demo;

import demo.service.UserService;
import demo.service.impl3.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/2/13
 * TestDemo1 在此扮演的角色为调用者/用户
 */
public class TestDemo3 {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //当调用者再需要改变业务逻辑调用，连调用者的代码都不再需要改了，只需要改动xml文件中的配置信息即可
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        userService.getUser();
    }
}
