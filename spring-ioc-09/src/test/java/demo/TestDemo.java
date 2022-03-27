package demo;

import com.demo1.config.AppConfig;
import com.demo1.pojo.Human;
import com.demo1.pojo2.Bird;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
public class TestDemo {

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Human human1 = context.getBean("getHuman1", Human.class);
        Human human2 = context.getBean("human", Human.class);
        human1.playPet();
        human2.playPet();
        AnnotationConfigApplicationContext annoContext = (AnnotationConfigApplicationContext) context;
        //将java类注入到SpringIOC容器中
        annoContext.register(Bird.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
