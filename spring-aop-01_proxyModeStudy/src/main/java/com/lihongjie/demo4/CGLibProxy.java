package com.lihongjie.demo4;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lihongjie
 * @date 2022/3/20
 */
public class CGLibProxy implements MethodInterceptor {

    /**
     * @param proxy 代理对象（切忌不可以使用proxy.invoke否则会造成循环调用）
     * @param method 委托类方法
     * @param args 方法参数
     * @param methodProxy 每个被代理的方法都对应一个MethodProxy对象，
     *                    methodProxy.invokeSuper方法最终调用委托类（目标类）的原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //过滤需要增强的业务的方法
        Object res = null;
        if("excute".equals(method.getName())){
            System.out.println("CGlib动态代理，方法增强——权限校验");
            //调用目标对象代理方法（执行Target对象即被代理对象的excute方法）
            res = methodProxy.invokeSuper(proxy, args);
            //循环调用代理方法会造成循环调用
            //res = methodProxy.invoke(proxy, args);
            System.out.println("CGlib动态代理，方法增强——日志记录");
        }
        //若不需要增强则执行原方法
        return res;
    }
}
