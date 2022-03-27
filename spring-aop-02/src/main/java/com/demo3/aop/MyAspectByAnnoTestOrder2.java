package com.demo3.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Spring2.0引入的注解方式
 * @author lihongjie
 * @date 2022/3/19
 */
//注释该类是一个切面
@Aspect
//切面需要装配到SpringIOC容器中，交给Spring托管
@Component
public class MyAspectByAnnoTestOrder2 implements Ordered {
    /**
     * 前置通知
     */
    @Before("execution(* com.demo3..UserDaoImpl2.add(..)) && args(user, ..)")
    public void before(String user){
        System.out.println("MyAspectByAnnoTestOrder2======>前置通知1，获取到的参数为：" + user);
    }

    /**
     * 后置通知
     */
    //匹配com.demo2包及其子包中所有类的所有方法
    @AfterReturning(value = "within(com.demo3..UserDaoImpl2)", returning = "returnVal")
    public void afterReturning(Object returnVal){
        System.out.println("MyAspectByAnnoTestOrder2======>后置通知1，返回值为：" + returnVal);
    }

    /**
     * 定义优先级，值越低，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 2;
    }
}
