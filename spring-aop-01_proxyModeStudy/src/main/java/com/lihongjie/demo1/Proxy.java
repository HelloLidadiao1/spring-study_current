package com.lihongjie.demo1;

/**
 * @author lihongjie
 * @date 2022/3/17
 */
/**
 * 本例中的中介（代理模式中的代理）
 */
public class Proxy implements Rent{

    /**
     * 组合，实际所需要代理的角色（这里采用多态的思想）
     */
    private Rent rent;

    public Proxy(Rent rent) {
        this.rent = rent;
    }

    public Proxy() {
    }

    @Override
    public void rentHouse() {
        seeHouse();
        rent.rentHouse();
        fee();
        contract();
    }

    /**
     * 拓展功能1
     */
    private void seeHouse(){
        System.out.println("带客户看房子......");
    }

    /**
     * 拓展功能2
     */
    private void fee(){
        System.out.println("收取中介费用....");
    }

    /**
     * 拓展功能3
     */
    private void contract(){
        System.out.println("签署租赁合同....");
    }
}
