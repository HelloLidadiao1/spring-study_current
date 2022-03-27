package demo;

import com.demo2.dao.UserDao2;
import com.demo3.dao.UserDao3;
import com.demo3.dao.impl.UserDaoNotInterfaceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lihongjie
 * @date 2022/3/19
 */
// 测试使用SpringAOP方式三
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext_anno_method3.xml", "classpath:applicationContext_basexml_method2.xml"})
public class TestDemoBySpring {
    @Autowired
    private UserDao3 userDao3;

    @Autowired
    private UserDao2 userDao2;

    @Autowired
    private UserDaoNotInterfaceImpl userDaoNotInterfaceImpl;

    // 测试使用SpringAOP方式三，基于@Aspect
    @Test
    public void testAspect3(){
        //userDao3.add("hhhhh");
        userDao3.update("aaa", "bbb");
        userDaoNotInterfaceImpl.add("lihongjie");
    }

    // 测试使用SpringAOP方式二，基于SpringAPI
    @Test
    public void testAspect2(){
        userDao2.add("hhhhh");
    }
}
