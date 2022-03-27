package com.demo2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 基于Spring提供的api来实现SpringAOP
 * @author lihongjie
 * @date 2022/3/19
 */
public class MySpringApiAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    /**
     * 前置通知
     * @param method 被代理对象方法
     * @param args 方法参数
     * @param target 被代理对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("进入基于Spring提供的api来实现SpringAOP的前置通知=====》" + target);
    }

    /**
     * 后置通知（非最终）
     * @param returnValue 方法返回值
     * @param method 被代理对象方法
     * @param args 方法参数
     * @param target 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("进入基于Spring提供的api来实现SpringAOP的后置通知（非最终）=====》" + returnValue);
    }
}
