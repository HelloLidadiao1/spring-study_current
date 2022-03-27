package com.demo1.pojo2;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
public class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shout(){
        System.out.println("叽叽~");
    }
}
