package com.demo1.pojo;

/**
 * @author lihongjie
 * @date 2022/3/7
 */
public class User {
    private Integer uId;
    private String uName;
    private Address address;

    public User(){

    }

    public User(Integer uId, String uName, Address address) {
        System.out.println("User配置的是p命名空间，测试是否执行对应的构造方法....");
        this.uId = uId;
        this.uName = uName;
        this.address = address;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        System.out.println("User配置的是p命名空间，测试是否执行对应属性的set方法....");
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", address=" + address +
                '}';
    }
}
