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
        User importUser = context.getBean("user", User.class);
        System.out.println("使用import标签之后，获取到的user：" + importUser);
        //测试别名<alias>标签
        System.out.println("userAlias--->" + context.getBean("userAlias", User.class));
        //测试通过bean的name标签给bean起别名
        System.out.println("userAlias--->" + context.getBean("u1", User.class));
        System.out.println("userAlias--->" + context.getBean("u2", User.class));
        System.out.println("userAlias--->" + context.getBean("u3", User.class));
        System.out.println("userAlias--->" + context.getBean("u4", User.class));
    }
}
