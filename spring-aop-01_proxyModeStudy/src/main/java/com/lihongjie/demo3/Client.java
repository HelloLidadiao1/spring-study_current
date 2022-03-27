package com.lihongjie.demo3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler();
        invocationHandler.setTarget(userService);
        //基于jdk的动态代理，demo实现
        /*UserService userService1 = (UserService)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(),
                new Class[]{UserService.class},
                invocationHandler);*/
        /**
         * 第一个参数：类加载器（任一代码中的类获取的类加载器都可，因为获取到的类加载器都是同一个）
         * 第二个参数：代理类实现的接口列表
         * 第三个参数：代理实例关联的调用处理程序对象（其实就是相当于代理实例执行的代理方法）
         */
        UserService proxyUserService = (UserService)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), userService.getClass().getInterfaces(),
                invocationHandler);
        //JDK的动态代理是基于接口的，直接转成实现类会报错：com.sun.proxy.$Proxy0 cannot be cast to com.lihongjie.demo3.UserServiceImpl
        /*UserServiceImpl proxyUserService2 = (UserServiceImpl) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), userService.getClass().getInterfaces(),
                invocationHandler);*/
        // 第二个参数如果不是传入接口的class数组，则会报错
        /*UserServiceImpl proxyUserService2 = (UserServiceImpl)Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), new Class[]{UserServiceImpl.class},
                invocationHandler);*/
        proxyUserService.add();
        //proxyUserService2.test();
        System.out.println(proxyUserService.getClass());   //class com.sun.proxy.$Proxy0
        //注意：基于jdk的动态代理，只有代理类从实现的接口中实现（继承）过来的方法才能被代理
        /*UserServiceImpl proxyUserServiceImpl = (UserServiceImpl) proxyUserService;
        proxyUserServiceImpl.test();*/
    }

    @Test
    public void test1(){
        //获取类所实现的接口列表
        Class<?>[] interfaces = UserServiceImpl.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }
}
