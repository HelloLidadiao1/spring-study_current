package com.demo.pojo.anotation;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

/**
 * @author lihongjie
 * @date 2022/3/11
 */
public class HumanBySet {

    private Cat catPet;
    private Dog dog;
    private String name;
    private Integer id;

    public Cat getCat() {
        return catPet;
    }

    @Autowired
    public void setCatPet111(@Nullable Cat catPet) {
        System.out.println("测试@autowire标签，经过setCatPet方法.....");
        this.catPet = catPet;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
