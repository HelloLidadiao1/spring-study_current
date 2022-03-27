package com.lihongjie.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
public class ProxyInvocationHandler implements InvocationHandler {
    //private UserService target;
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //注意：这里不能直接用proxy
        Object res = method.invoke(target, args);
        return res;
    }

    private void log(String name){
        System.out.println("进入" + name +"方法....");
    }
}
