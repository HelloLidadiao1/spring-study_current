package demo;

import com.demo1.dao.UserDao;
import com.demo1.dao.impl.UserDaoNotInterfaceImpl;
import com.demo3.dao.UserDao3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/19
 */

/**
 * 通知执行的顺序：前置通知【before】 -> 环绕前置通知【around】 -> 切点方法执行 ->
 * 后置通知（最终）【after】 -> 异常通知【after-throwing】 -> 后置通知（切点方法执行成功，正常返回）【after-returning】
 *
 * 若切点方法发生异常：前置通知【before】 -> 环绕前置通知【around】 -> 切点方法执行 ->
 * 后置通知（最终）【after】 -> 异常通知【after-throwing】
 *
 * 注意：
 * after：是无论切点方法是否执行成功都会执行
 * after-returning：是只有当切点方法执行成功正常返回时才会执行
 *
 */
public class TestDemo {
    //测试方式一：使用在xml中自定义切面来使用SpringAOP
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_basexml_method1.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add("lihongjie");
        /*for (Class<?> anInterface : userDao.getClass().getInterfaces()) {
            System.out.print(anInterface + "\t");
        }*/
        System.out.println();
        userDao.query();
        //经测试，即使代理的目标类没有实现接口，也可以被Spring代理成功
        UserDaoNotInterfaceImpl userDaoNotInterfaceImpl = context.getBean("userDaoNotInterfaceImpl", UserDaoNotInterfaceImpl.class);
        userDaoNotInterfaceImpl.add("pengyuehong");
        /*for (Class<?> anInterface : userDaoNotInterfaceImpl.getClass().getInterfaces()) {
            System.out.print(anInterface + "\t");
        }*/
    }

    //测试方式三：使用@Aspect注解来使用SpringAOP
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_anno_method3.xml");
        //注意：要想使用SpringAOP，那么被代理的类，必须交给SpringIOC容器托管才可以，下面这种情况，配置的AOP就无法生效
        /*UserDao2 userDao2 = new UserDaoImpl2();
        userDao2.add("pengpangpang");
        System.out.println();*/
        //使用SpringAOP，代理的类如果有接口，必须要转换层
        UserDao3 userDao3 = context.getBean("userDaoImpl3", UserDao3.class);
        userDao3.add("pengpangpang");
    }
}
