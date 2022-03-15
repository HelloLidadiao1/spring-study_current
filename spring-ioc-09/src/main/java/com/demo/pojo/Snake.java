package com.demo.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lihongjie
 * @date 2022/3/15
 */
@Component
public class Snake {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shout(){
        System.out.println("嘶~");
    }
}
