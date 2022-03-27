package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo1.pojo.Student;

/**
 * @author lihongjie
 * @date 2022/3/5
 */
public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student stu = context.getBean(Student.class);
        System.out.println(stu);
    }
}
