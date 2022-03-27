package com.lihongjie.demo3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
// @Component 等价于：<bean id="user" class="com.lihongjie.demo.pojo.User" />
@Component
//@Scope("singleton")
@Scope("prototype")
public class User {
    private String uName;

    @Value("23")
    private Integer uId;

    public String getuName() {
        return uName;
    }

    //相当于 <property name="name" value="lihongjie">
    @Value("lihongjie")
    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uId=" + uId +
                '}';
    }
}
