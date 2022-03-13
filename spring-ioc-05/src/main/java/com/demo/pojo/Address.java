package com.demo.pojo;

import sun.security.x509.IPAddressName;

/**
 * @author lihongjie
 * @date 2022/3/5
 */
public class Address {
    private String addName;
    private Integer addrNo;

    public Address(Integer addrNo) {
        this.addrNo = addrNo;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public Integer getAddrNo() {
        return addrNo;
    }

    public void setAddrNo(Integer addrNo) {
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
