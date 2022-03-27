package com.lihongjie.demo1;

/**
 * @author lihongjie
 * @date 2022/3/17
 */

/**
 * 房东（代理模式中的真实的角色）
 */
public class HouseOwner implements Rent{

    @Override
    public void rentHouse() {
        System.out.println("房东出租房子.....");
    }
}
