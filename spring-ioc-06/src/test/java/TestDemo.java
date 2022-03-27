import com.demo1.pojo.User;
import com.demo1.pojo.UserScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/7
 */
public class TestDemo {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("noPAndCNameSpaceBeans.xml");
        String[] beanDefNames = context.getBeanDefinitionNames();
        for (String beanDefName : beanDefNames) {
            System.out.println(beanDefName);
        }
        User user = (User)context.getBean("user");
        System.out.println(user);

    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefNames = context.getBeanDefinitionNames();
        for (String beanDefName : beanDefNames) {
            System.out.println(beanDefName);
        }
        User user = (User)context.getBean("user");
        System.out.println(user);

    }

    /**
     * 测试：对于同一个类型，在beans.xml文件中定义的多个bean，使用的scope是默认的【singleton】看看从不同的bean标签获取到的对象是否是同一个
     * 测试结果：对同一个类型，定义了多个bean标签，即使scope用的是singleton，从每个不同的bean获取到的对象仍然是不同的。
     * 但是对于同一个bean标签获取的对象，必然是相同的。（只代表从该标签获取的对象是单例的）
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test_scope_beans.xml");
        UserScope defaultScopeUser1 = (UserScope)context.getBean("defaultScopeUser1");
        System.out.println(defaultScopeUser1);
        UserScope defaultScopeUser11 = (UserScope)context.getBean("defaultScopeUser1");
        System.out.println(defaultScopeUser11);
        UserScope defaultScopeUser2 = (UserScope)context.getBean("defaultScopeUser2");
        UserScope defaultScopeUser22 = (UserScope)context.getBean("defaultScopeUser2");
        System.out.println(defaultScopeUser2);
        System.out.println(defaultScopeUser22);
    }

    /**
     * 测试：scope为prototype
     * 测试结果：哪怕对于同一个bean标签获取的对象，都是不一样的
     */
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test_scope_beans.xml");
        UserScope prototypeScopeUser1 = (UserScope)context.getBean("prototypeScopeUser");
        System.out.println(prototypeScopeUser1);
        UserScope prototypeScopeUser11 = (UserScope)context.getBean("prototypeScopeUser");
        System.out.println(prototypeScopeUser11);
    }

    /**
     * 测试：scope为request、session等web类型
     * 测试结果：非web环境会报异常：No Scope registered for scope name 'request'【待springMvc才能测试】
     */
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("test_scope_beans.xml");
        UserScope requestScopeUser1 = (UserScope)context.getBean("requestScopeUser");
        System.out.println(requestScopeUser1);
        UserScope requestScopeUser11 = (UserScope)context.getBean("requestScopeUser");
        System.out.println(requestScopeUser11);

        UserScope sessionScopeUser1 = (UserScope)context.getBean("sessionScopeUser");
        System.out.println(sessionScopeUser1);
        UserScope sessionScopeUser11 = (UserScope)context.getBean("requestScopeUser");
        System.out.println(sessionScopeUser11);
    }
}
