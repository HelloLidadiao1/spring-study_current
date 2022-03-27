package com.demo3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Spring2.0引入的注解方式
 * @author lihongjie
 * @date 2022/3/19
 */
//注释该类是一个切面
@Aspect
//切面需要装配到SpringIOC容器中，交给Spring托管
@Component    //为了测试切面优先级暂时注释
public class MyAspectByAnno{
    @Pointcut("execution(public * com.demo3..*.*(..))")
    public void commonPointCut(){}

    /**
     * 前置通知
     */
    @Before("execution(* com.demo3..UserDaoImpl2.add(..)) && args(user, ..)")
    public void before(String user){
    //@Before("target(com.demo2.dao.impl.UserDaoImpl2)")
    //@Before("this(com.demo2.dao.UserDao2)")
        System.out.println("MyAspectByAnno======>前置通知1，获取到的参数为：" + user);
    }

    /**
     * 前置通知
     * @param joinPoint由Spring提供的静态变量 该参数可以获取目标对象的信息,如类名称,方法参数,方法名称等
     */
    @Before("execution(* com.demo3..UserDaoImpl2.add(..))")
    public void before2(JoinPoint joinPoint){
        //@Before("target(com.demo2.dao.impl.UserDaoImpl2)")
        //@Before("this(com.demo2.dao.UserDao2)")
        System.out.println("MyAspectByAnno======>前置通知2，获取到的参数为：" + joinPoint.getSignature());
    }

    /**
     * 后置通知
     */
    //匹配com.demo2包及其子包中所有类的所有方法
    /*@AfterReturning(value = "within(com.demo2..*)", returning = "returnVal")
    public void afterReturning(Object returnVal){
        System.out.println("MyAspectByAnno======>后置通知，返回值为：" + returnVal);
    }*/

    /**
     * 环绕通知
     * @param joinPoint 连接点
     * @return 方法执行返回值
     */
    @Around(value = "execution(* com.demo3..UserDaoImpl3.update(..)) && args(user, name)", argNames = "joinPoint, user, name")
    //ProceedingJoinPoint joinPoint参数不在第一个代码会报错
    public Object around(ProceedingJoinPoint joinPoint, String aaa, String bbb) throws Throwable {
        System.out.println("MyAspectByAnno======>环绕通知前,获取到的参数为：" + aaa + "\t" + bbb);
        Object result = joinPoint.proceed();
        System.out.println("MyAspectByAnno======>环绕通知后，方法执行返回结果为：" + result);
        return result;
    }

    /**
     * 异常通知
     * @param ex 捕获到的异常
     */
    @AfterThrowing(value = "commonPointCut()", throwing = "ex")
    public void afterThrowable(Throwable ex){
        System.out.println("MyAspectByAnno======>异常通知，捕获到的异常信息：" + ex.getLocalizedMessage());
    }

    /**
     * 后置通知（最终）<====> 类比finally
     */
    @After(value = "execution(public * *(..))")
    public void after(){
        System.out.println("MyAspectByAnno======>后置通知（最终）");
    }

}
