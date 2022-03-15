package com.demo.pojo.anotation;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * 将@Autowired注解加到属性上实现自动注入
 * @author lihongjie
 * @date 2022/3/11
 */
public class HumanByConstructor {
    private Cat catPet;
    private Dog dog;
    private String name;
    private Integer id;

    public HumanByConstructor(){

    };

    @Autowired(required = false)
    public HumanByConstructor(Cat catPet, Dog dog, String name, Integer id) {
        System.out.println("测试@autowire标签，进入有参构造方法.....");
        this.catPet = catPet;
        this.dog = dog;
        this.name = name;
        this.id = id;
    }

    public Cat getCat() {
        return catPet;
    }

    public Dog getDog() {
        return dog;
    }


    public String getName() {
        return name;
    }


    public Integer getId() {
        return id;
    }

}
