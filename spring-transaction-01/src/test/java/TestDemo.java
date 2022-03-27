import com.lihongjie.demo.exception.MyException;
import com.lihongjie.demo.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/25
 */
public class TestDemo {
    public static void main(String[] args) throws MyException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_noAnno.xml");
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        userService.opeUser(true);
        //userService.propagationTestB();
    }
}
