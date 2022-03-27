package demo;

import com.lihongjie.demo.mapper.StuMapper;
import com.lihongjie.demo.mapper.UserMapper;
import com.lihongjie.demo.mapper.UserMapperImpl;
import com.lihongjie.demo.mapper2.UserMapper2;
import com.lihongjie.demo.mapper2.UserMapperImpl2;
import com.lihongjie.demo.pojo.Student;
import com.lihongjie.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lihongjie
 * @date 2022/3/21
 */
public class TestDemo {
    /*
    *  测试spring-mybatis第一种整合方式，该方式省略配置sqlSessionTemplate。
    *  配置的MapperFactoryBean 将会负责 SqlSession 的创建和关闭。
    *  如果使用了 Spring 的事务功能，那么当事务完成时，session 将会被提交或回滚。
    * 最终任何异常都会被转换成 Spring 的 DataAccessException 异常。
    */
    @Test
    public void testSpringUnionMybatis1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao-way1.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        System.out.println(userMapper.getClass());
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        StuMapper stuMapper = context.getBean("stuMapper", StuMapper.class);
        Random random = new Random();
        List<Integer> numList = new ArrayList<>(Arrays.asList(6,7,8));
        List<Student> stus = Stream.generate(() -> {
            int i = random.nextInt(3);
            Student student = new Student(numList.get(0), "lihongjie" + i, i);
            numList.remove(0);
            return student;
        }).limit(3).collect(Collectors.toList());
        stuMapper.insertStus(stus);
    }

    /*
     *  测试spring-mybatis第二种整合方式  From kuangshen
     *  该方式会配置SqlSessionTemplate，以及为mapper接口增加实现类
     */
    @Test
    public void testSpringUnionMybatis2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_way2.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
        List<User> users = userMapper.selectUser();
        /*for (User user : users) {
            user.setUName(user.getUName() + "_temp");
        }
        userMapper.updUsers(users);*/
        System.out.println(userMapper.selectUser());
    }

    /**
     * spring整合mybatis方式三：
     *     通过继承SqlSessionDaoSupport类获取SqlSessionTemplate
     */
    @Test
    public void testSpringUnionMybatis3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao-way3.xml");
        UserMapper2 userMapper = context.getBean("userMapper", UserMapperImpl2.class);
        System.out.println(userMapper.selectUser());
    }
}
