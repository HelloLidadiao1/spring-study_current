package com.demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 基于xml实现得SpringAop（注意：未用到aspectj，也未使用到注解）
 * @author lihongjie
 * @date 2022/3/19
 */
public class MyAspectXml {
    /**
     * 前置通知
     */
    public void before(String uName){
        System.out.println("MyAspectXml========>前置通知,获取到的参数为：" + uName);
    }

    /**
     * 后置通知，当方法正常返回后执行
     * @param returnVal
     */
    public void afterReturning(Object returnVal, String aaa){
        System.out.println("MyAspectXml========>后置通知（afterReturning），返回值为：" + returnVal + "，获取到的参数为：" + aaa);
        System.out.println();
    }

    /**
     * 环绕通知
     * @param joinPoint 用以控制切点方法是否继续执行
     * @return 切点方法执行结果
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("MyAspectXml========>环绕通知前置");
        Object result = joinPoint.proceed();
        System.out.println("MyAspectXml========>环绕通知后置");
        return result;
    }

    /**
     * 异常通知
     */
    public void afterThrowing(Throwable throwable){
        System.out.println("MyAspectXml========>异常通知：" + throwable.getLocalizedMessage());
    }

    /**
     * 后置通知（最终）无论切点方法是否正常执行完毕还是发生异常，都会被执行
     */
    public void after(){
        System.out.println("MyAspectXml========>后置通知（最终）");
    }
}
