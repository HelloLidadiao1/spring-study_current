package com.lihongjie.demo1;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
public class Client {
    public static void main(String[] args) {
        HouseOwner houseOwner = new HouseOwner();
        Proxy proxy = new Proxy(houseOwner);
        proxy.rentHouse();
    }
}
