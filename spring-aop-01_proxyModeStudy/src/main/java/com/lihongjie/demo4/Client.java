package com.lihongjie.demo4;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author lihongjie
 * @date 2022/3/20
 */
public class Client {
  public static void main(String[] args) {
    // 测试CGLIB动态代理技术
    // 1.声明增强类实例，用于生产代理类
    Enhancer enhancer = new Enhancer();
    // 2.设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
    enhancer.setSuperclass(Target.class);
    // 3.设置回调函数（代理方法增强），即一个方法拦截
    enhancer.setCallback(new CGLibProxy());
    // 4.创建代理：
    Target proxy = (Target)enhancer.create();
    proxy.excute();
    // class com.lihongjie.demo4.Target$$EnhancerByCGLIB$$7dfd4e1d
    System.out.println(proxy.getClass());
  }
}
