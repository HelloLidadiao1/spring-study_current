package com.demo1.pojo;

/**
 * @author lihongjie
 * @date 2022/3/5
 */
public class Address {
    private String addName;
    private Integer addrNo;

    public Address(Integer addrNoTemp) {
        System.out.println("Address配置的是c命名空间，测试是否执行对应的有参构造方法....");
        this.addrNo = addrNoTemp;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddNameTemp(String addNameTemp) {
        this.addName = addNameTemp;
    }

    public Integer getAddrNo() {
        return addrNo;
    }

    public void setAddrNo(Integer addrNo) {
        System.out.println("Address配置的是c命名空间，测试是否执行对应属性的set方法....");
        this.addrNo = addrNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addName='" + addName + '\'' +
                ", addrNo=" + addrNo +
                '}';
    }
}
