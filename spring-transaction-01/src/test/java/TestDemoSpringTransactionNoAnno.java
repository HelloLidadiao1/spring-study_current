import com.lihongjie.demo.exception.MyException;
import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.pojo.User;
import com.lihongjie.demo.service.UserService;
import com.lihongjie.demo.service.impl.UserServiceImpl;
import com.lihongjie.demo.service.impl.UserServiceImplByAnno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihongjie
 * @date 2022/3/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext_noAnno.xml"})
public class TestDemoSpringTransactionNoAnno {

    //这里因为要测试UserServiceImpl中非继承实现的方法，故直接使用实现类类型
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * Spring声明式事务方式1：基于xml配置事务切面
     */
    @Test
    public void testTransAction1() throws MyException {
        //userService.opeUser(true);
        userService.opeUser(false);
        /*List<User> users = new ArrayList<>();
        users.add(new User(15, "test_transaction1", "lihongjie@qq.com"));
        userMapper.insUser(users);
        //在没有事务的情况下，即使delUser报错了，但是插入用户仍然成功了，这是一个完整的业务，只完成一部分显然不符合要求
        userMapper.delUser(15);
        userMapper.selUser();*/
    }

    /**
     * 测试事务的传播特性
     *
     */
    @Test
    public void testTransAction2() throws MyException {
        //userService.propagationTestB();

       //propagationTestA ：NEVER、propagationTestB ：REQUIRED
        userService.propagationTestA();
    }
}
