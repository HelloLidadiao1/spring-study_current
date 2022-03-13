package demo;

import demo.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/2/13
 */
public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //对于获取同一个bean的时候是单例模式
        User user1 = (User)context.getBean("user");
        User user2 = (User)context.getBean("user");
        //但是获取不同得bean，即使类型还是相同得话就不是同一个实例了
        User userTemp = (User)context.getBean("userTemp");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(userTemp);
        System.out.println(user1 == userTemp);
        System.out.println(user1 == user2);
        User userUseSet = (User)context.getBean("userUseSet");
    }
}
