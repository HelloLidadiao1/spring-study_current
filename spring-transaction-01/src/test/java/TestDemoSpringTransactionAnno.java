import com.lihongjie.demo.exception.MyException;
import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.service.UserService;
import com.lihongjie.demo.service.impl.UserServiceImplByAnno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author lihongjie
 * @date 2022/3/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext_anno.xml"})
public class TestDemoSpringTransactionAnno {

    @Autowired
    private UserService userService;

    /*注意：若该类加了切面通知，被SpringAop所代理了，那么从Spring容器中获取到的是该类的代理类。
     *需要根据使用的是JDK动态代理【需要用接口接收】，还是cglib动态代理【用原类型接收即可】，来确定接受该对象的返回值类型
     */
    @Resource(name = "userService")
    private UserServiceImplByAnno userServiceImplByAnno;

    @Autowired
    private UserMapper userMapper;

    /**
     * Spring声明式事务方式2：基于开启事务注解驱动 + @Transactional
     */
    @Test
    public void testTransAction2() throws MyException {
        // 测试@Transactional加在方法上
        userService.opeUser(false);

        //测试@Transactional，加在非公有方法上，通过对外提供一个public方法进行转调
        userServiceImplByAnno.callOpeUserPrivate();
    }

    //测试隔离级别
    @Test
    public void testTransAction3() throws MyException {
        //userServiceImplByAnno.propagationTestB();
        userServiceImplByAnno.propagationTestA();
    }
}
