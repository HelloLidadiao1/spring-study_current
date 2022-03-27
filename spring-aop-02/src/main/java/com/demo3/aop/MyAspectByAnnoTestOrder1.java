package com.demo3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
public class MyAspectByAnnoTestOrder1 implements Ordered {
    @Pointcut("execution(public * com.demo3.dao.impl.UserDaoImpl3.*(..))")
    public void commonPointCut(){}

    /**
     * 前置通知
     */
    @Before("execution(* com.demo3..UserDaoImpl2.add(..)) && args(user, ..)")
    public void before(String user){
        System.out.println("MyAspectByAnnoTestOrder1======>前置通知1，获取到的参数为：" + user);
    }

    /**
     * 前置通知
     * @param joinPoint 由Spring提供的静态变量 该参数可以获取目标对象的信息,如类名称,方法参数,方法名称等
     */
    @Before("execution(* com.demo3..UserDaoImpl2.add(..))")
    public void before2(JoinPoint joinPoint){
        //@Before("target(com.demo2.dao.impl.UserDaoImpl2)")
        //@Before("this(com.demo2.dao.UserDao2)")
        System.out.println("MyAspectByAnnoTestOrder1======>前置通知2，获取到的参数为：" + joinPoint.getSignature());
    }

    /**
     * 后置通知
     */
    //匹配com.demo2包及其子包中所有类的所有方法
    @AfterReturning(value = "within(com.demo3..UserDaoImpl2)", returning = "returnVal")
    public void afterReturning(Object returnVal){
        System.out.println("MyAspectByAnnoTestOrder1======>后置通知1，返回值为：" + returnVal);
    }

    /**
     * 后置通知
     */
    //匹配com.demo2包及其子包中所有类的所有方法
    @AfterReturning(value = "within(com.demo3..UserDaoImpl2)", returning = "returnVal")
    public void afterReturning2(Object returnVal){
        System.out.println("MyAspectByAnnoTestOrder1======>后置通知2，返回值为：" + returnVal);
    }

    /**
     * 定义优先级，值越低，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
