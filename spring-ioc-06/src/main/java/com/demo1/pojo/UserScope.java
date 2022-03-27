package com.demo1.pojo;

/**
 * @author lihongjie
 * @date 2022/3/7
 */
public class UserScope {
    private Integer uId;
    private String uName;
    private Address address;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
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
}
