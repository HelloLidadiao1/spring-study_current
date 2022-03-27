package demo;

import com.lihongjie.demo3.controller.UserController;
import com.lihongjie.demo3.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
public class TestDemo {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        UserController userController = context.getBean("userController", UserController.class);
        userController.getUser();
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
